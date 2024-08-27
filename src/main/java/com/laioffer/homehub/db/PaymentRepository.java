package com.laioffer.homehub.db;

import com.laioffer.homehub.db.entity.PaymentEntity;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface PaymentRepository extends ListCrudRepository<PaymentEntity, Long> {
	PaymentEntity findByEventId(Long eventId);
	List<PaymentEntity> findByPayFrom(Long payFrom);
	List<PaymentEntity> findByPayTo(Long payTo);
	List<PaymentEntity> findByStatus(Integer status);

	@Modifying
	@Query("UPDATE payment SET status = 1 WHERE id = :id")
	void payById(@Id id);
}
