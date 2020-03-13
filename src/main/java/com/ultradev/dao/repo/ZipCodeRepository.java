package com.ultradev.dao.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ultradev.dao.entity.ZipCodeInfo;

/**
 * 
 * @author shashank
 *
 */
@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCodeInfo, Long> {
	List<ZipCodeInfo> findByAdmincode1(String admincode1);
	List<ZipCodeInfo> findByPostalcode(String postalCode);
}
