package com.laioffer.homehub.db.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("payment")
public record PaymentEntity(
	@Id Long id,
	Long payFrom,
	Long payTo,
	Long eventId,
	String description,
	LocalDateTime creationDate,
	LocalDateTime paymentDate,
	Integer status) {
}
