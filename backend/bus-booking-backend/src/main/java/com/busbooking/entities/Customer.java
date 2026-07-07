package com.busbooking.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude="userDetails")
	
public class Customer extends BaseClass{
	@Id
    @Column(name = "customer_id")
    private Long id;
	@Column(name="loyalty_points")
	private Integer loyaltyPoints;
	
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	@MapsId
	private User userDetails;
}
