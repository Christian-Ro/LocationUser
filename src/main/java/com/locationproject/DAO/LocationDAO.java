package com.locationproject.DAO;

import com.locationproject.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDAO extends JpaRepository<Location, Integer> {
}
