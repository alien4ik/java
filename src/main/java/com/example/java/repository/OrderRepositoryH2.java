package com.example.java.repository;
import com.example.java.Models.Order;
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
public class OrderRepositoryH2 implements OrderRepository {

    private static final String CREATE = """
                        insert into orders (orderId, clientId, price, orderTime)
                        values (:orderId, :clientId, :price, :orderTime)
            """;
    private static final String UPDATE = """
            UPDATE orders
            SET clientId = :clientId,
            price = :price,
            orderTime = :orderTime
            WHERE orderId = :orderId
            """;

    private final RowMapper<Order> rowMapper = new DataClassRowMapper<>(Order.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OrderRepositoryH2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Order read(Integer orderId) {
        try {
            return jdbcTemplate.queryForObject("select * from orders where orderId = ?", rowMapper, orderId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("order with id = [" + orderId + "] not found", e);
        }
    }

    @Override
    public List<Order> readAll() {

        return jdbcTemplate.query("select * from orders", rowMapper);
    }


    @Override
    public void create(Order order) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(order);
        namedParameterJdbcTemplate.update(CREATE, paramsSource);
    }

    @Override
    public void update(Order order, Integer orderId) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(order);
        namedParameterJdbcTemplate.update(UPDATE, paramsSource);
    }

    @Override
    public void delete(Integer orderId) {
        jdbcTemplate.update("DELETE FROM orders where orderId = ?",orderId);
    }

}