package com.busbooking.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "bookings",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "booking_reference"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    /*
     * Customer who made the booking.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    /*
     * Trip for which the booking was created.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "trip_id",
            nullable = false
    )
    private Trip trip;

    /*
     * Human-readable booking reference / PNR.
     */
    @Column(
            name = "booking_reference",
            nullable = false,
            unique = true,
            length = 30
    )
    private String bookingReference;

    /*
     * Payment service transaction reference.
     */
    @Column(
            name = "payment_id",
            nullable = false,
            length = 100
    )
    private String paymentId;

    /*
     * Razorpay order associated with this booking.
     */
    @Column(
            name = "razorpay_order_id",
            nullable = false,
            length = 100
    )
    private String razorpayOrderId;

    /*
     * Fare before additional charges.
     */
    @Column(
            name = "fare",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal fare;

    /*
     * Convenience/platform fee.
     */
    @Column(
            name = "convenience_fee",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal convenienceFee;

    /*
     * GST amount.
     */
    @Column(
            name = "gst",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal gst;

    /*
     * Final amount actually paid.
     */
    @Column(
            name = "total_amount",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal totalAmount;

    /*
     * Current booking state.
     */
    @Enumerated(EnumType.STRING)
    @Column(
            name = "booking_status",
            nullable = false,
            length = 20
    )
    private BookingStatus bookingStatus;

    /*
     * Passenger records belonging to this booking.
     */
    @OneToMany(
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BookingPassenger> passengers =
            new ArrayList<>();

    /*
     * Seat records belonging to this booking.
     */
    @OneToMany(
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BookingSeat> bookingSeats =
            new ArrayList<>();
}