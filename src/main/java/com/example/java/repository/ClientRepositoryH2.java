package com.example.java.repository;

import com.example.java.Models.Client;
import com.example.java.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryH2 implements ClientRepository {

    private static final String CREATE = """
                        insert into clients (clientId, email, surname, birthday, male)
                        values (:clientId, :email, :surname, :birthday, :male)
            """;
    private static final String UPDATE = """
            UPDATE clients
            SET email = :email,
            surname = :surname,
            birthday = :birthday,
            male = :male
            WHERE clientId = :clientId
            """;

    private final RowMapper<Client> rowMapper = new DataClassRowMapper<>(Client.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ClientRepositoryH2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Client read(Integer id) {
        try {
            return jdbcTemplate.queryForObject("select * from clients where clientId = ?", rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Client with id = [" + id + "] not found", e);
        }
    }

    @Override
    public List<Client> readAll() {
        return jdbcTemplate.query("select * from clients", rowMapper);
    }

    @Override
    public void create(Client client) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(client);
        namedParameterJdbcTemplate.update(CREATE, paramsSource);
    }

    @Override
    public void update(Client client, Integer clientId) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(client);
        namedParameterJdbcTemplate.update(UPDATE, paramsSource);
    }

    @Override
    public void delete(Integer clientId) {
        jdbcTemplate.update("DELETE FROM clients where clientId = ?",clientId);
    }

}