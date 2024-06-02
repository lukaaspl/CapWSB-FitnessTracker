package com.capgemini.wsb.fitnesstracker.user.internal;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.wsb.fitnesstracker.user.api.User;

interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Query searching users by email address. It matches by exact match.
     *
     * @param email email of the user to search
     * @return {@link Optional} containing found user or {@link Optional#empty()} if
     *         none matched
     */
    default Optional<User> findByExactEmail(String email) {
        return findAll().stream()
                .filter(user -> Objects.equals(user.getEmail(), email))
                .findFirst();
    }

    /**
     * Query searching users by email address containing a specific string, ignoring
     * case.
     *
     * @param emailPart the partial email address to search for
     * @return a list of users whose email address contains the specified string,
     *         ignoring case
     */
    default List<User> findAllByEmailPart(String emailPart) {
        return findAll().stream()
                .filter(user -> user.getEmail().toLowerCase().contains(emailPart.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Query searching users older than a specific date.
     * 
     * @param date the date to compare with
     * @return a list of users whose birthdate is before the specified date
     * 
     */
    default List<User> findAllOlderThanDate(LocalDate date) {
        return findAll().stream()
                .filter(user -> user.getBirthdate().isBefore(date))
                .collect(Collectors.toList());
    }

}
