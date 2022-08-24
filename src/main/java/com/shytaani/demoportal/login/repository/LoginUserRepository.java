package com.shytaani.demoportal.login.repository;

import java.util.List;
import java.util.Optional;

import com.shytaani.demoportal.login.entity.LoginUser;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginUserRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public LoginUserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<LoginUser> findUser(String username) {
        String sql = "SELECT * FROM \"user\" WHERE name = :username";
        MapSqlParameterSource param = new MapSqlParameterSource("username", username);
        ResultSetExtractor<LoginUser> extractor = rs -> {
            if (rs.next()) {
                return new LoginUser(rs.getString("name"), rs.getString("password"), getRoles(rs.getInt("id")));
            }
            return null;
        };
        LoginUser user = jdbcTemplate.query(sql, param, extractor);
        return Optional.ofNullable(user);
    }

    private List<String> getRoles(int userId) {
        String sql = "SELECT r.name FROM user_role ur INNER JOIN role r ON r.id = ur.role_id WHERE ur.user_id = :userId";
        MapSqlParameterSource param = new MapSqlParameterSource("userId", userId);
        return jdbcTemplate.queryForList(sql, param, String.class);
    }
}
