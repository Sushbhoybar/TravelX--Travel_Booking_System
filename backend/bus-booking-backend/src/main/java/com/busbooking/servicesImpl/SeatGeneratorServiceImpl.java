package com.busbooking.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.busbooking.entities.Bus;
import com.busbooking.entities.BusType;
import com.busbooking.entities.DeckType;
import com.busbooking.entities.Seat;
import com.busbooking.entities.SeatCategory;
import com.busbooking.entities.SeatPosition;
import com.busbooking.repository.SeatRepository;
import com.busbooking.services.SeatGeneratorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatGeneratorServiceImpl
        implements SeatGeneratorService {

    private final SeatRepository seatRepository;

    @Override
    public void generateSeats(Bus bus) {

        if (seatRepository.countByBus(bus) > 0) {
            return;
        }

        switch (bus.getBusType()) {

            case AC_SEATER:
            case NON_AC_SEATER:
                generateSeaterLayout(bus);
                break;

            case AC_SLEEPER:
            case NON_AC_SLEEPER:
                generateSleeperLayout(bus);
                break;

            case SEMI_SLEEPER:
                generateSemiSleeperLayout(bus);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported Bus Type");
        }

    }

    private void generateSeaterLayout(Bus bus) {

        List<Seat> seats = new ArrayList<>();

        int totalSeats = bus.getTotalSeats();

        int row = 1;

        int seatIndex = 1;

        while (seatIndex <= totalSeats) {

            // Left Window
            if (seatIndex <= totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("A" + seatIndex);
                seat.setRowNo(row);
                seat.setColumnNo(1);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SEATER);
                seat.setSeatPosition(SeatPosition.LEFT_WINDOW);

                seats.add(seat);

                seatIndex++;

            }

            // Left Aisle
            if (seatIndex <= totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("A" + seatIndex);
                seat.setRowNo(row);
                seat.setColumnNo(2);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SEATER);
                seat.setSeatPosition(SeatPosition.LEFT_AISLE);

                seats.add(seat);

                seatIndex++;

            }

            // Right Aisle
            if (seatIndex <= totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("A" + seatIndex);
                seat.setRowNo(row);
                seat.setColumnNo(3);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SEATER);
                seat.setSeatPosition(SeatPosition.RIGHT_AISLE);

                seats.add(seat);

                seatIndex++;

            }

            // Right Window
            if (seatIndex <= totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("A" + seatIndex);
                seat.setRowNo(row);
                seat.setColumnNo(4);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SEATER);
                seat.setSeatPosition(SeatPosition.RIGHT_WINDOW);

                seats.add(seat);

                seatIndex++;

            }

            row++;

        }

        seatRepository.saveAll(seats);

    }

    private void generateSleeperLayout(Bus bus) {

        List<Seat> seats = new ArrayList<>();

        int totalSeats = bus.getTotalSeats();

        int row = 1;

        int berthIndex = 1;

        while (seats.size() < totalSeats) {

            // ============================
            // Left Lower
            // ============================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("LL" + berthIndex);
                seat.setRowNo(row);
                seat.setColumnNo(1);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SLEEPER);
                seat.setSeatPosition(SeatPosition.LEFT_WINDOW);

                seats.add(seat);

            }

            // ============================
            // Left Upper
            // ============================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("LU" + berthIndex);
                seat.setRowNo(row);
                seat.setColumnNo(1);
                seat.setDeck(DeckType.UPPER);
                seat.setSeatCategory(SeatCategory.SLEEPER);
                seat.setSeatPosition(SeatPosition.LEFT_WINDOW);

                seats.add(seat);

            }

            // ============================
            // Right Lower
            // ============================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("RL" + berthIndex);
                seat.setRowNo(row);
                seat.setColumnNo(4);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SLEEPER);
                seat.setSeatPosition(SeatPosition.RIGHT_WINDOW);

                seats.add(seat);

            }

            // ============================
            // Right Upper
            // ============================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("RU" + berthIndex);
                seat.setRowNo(row);
                seat.setColumnNo(4);
                seat.setDeck(DeckType.UPPER);
                seat.setSeatCategory(SeatCategory.SLEEPER);
                seat.setSeatPosition(SeatPosition.RIGHT_WINDOW);

                seats.add(seat);

            }

            berthIndex++;

            row++;

        }

        seatRepository.saveAll(seats);

    }

    private void generateSemiSleeperLayout(Bus bus) {

        List<Seat> seats = new ArrayList<>();

        int totalSeats = bus.getTotalSeats();

        int row = 1;

        int seaterIndex = 1;

        int berthIndex = 1;

        while (seats.size() < totalSeats) {

            // ==================================
            // Left Window Seat
            // ==================================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("A" + seaterIndex++);
                seat.setRowNo(row);
                seat.setColumnNo(1);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SEATER);
                seat.setSeatPosition(SeatPosition.LEFT_WINDOW);

                seats.add(seat);

            }

            // ==================================
            // Left Aisle Seat
            // ==================================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("A" + seaterIndex++);
                seat.setRowNo(row);
                seat.setColumnNo(2);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SEATER);
                seat.setSeatPosition(SeatPosition.LEFT_AISLE);

                seats.add(seat);

            }

            // ==================================
            // Right Lower Berth
            // ==================================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("RL" + berthIndex);
                seat.setRowNo(row);
                seat.setColumnNo(4);
                seat.setDeck(DeckType.LOWER);
                seat.setSeatCategory(SeatCategory.SLEEPER);
                seat.setSeatPosition(SeatPosition.RIGHT_WINDOW);

                seats.add(seat);

            }

            // ==================================
            // Right Upper Berth
            // ==================================

            if (seats.size() < totalSeats) {

                Seat seat = new Seat();

                seat.setBus(bus);
                seat.setSeatNumber("RU" + berthIndex);
                seat.setRowNo(row);
                seat.setColumnNo(4);
                seat.setDeck(DeckType.UPPER);
                seat.setSeatCategory(SeatCategory.SLEEPER);
                seat.setSeatPosition(SeatPosition.RIGHT_WINDOW);

                seats.add(seat);

            }

            berthIndex++;

            row++;

        }

        seatRepository.saveAll(seats);

    }
    
    private void setSeatFlags(Seat seat) {

        switch (seat.getSeatPosition()) {

            case LEFT_WINDOW:
            case RIGHT_WINDOW:

                seat.setWindowSeat(true);
                seat.setAisleSeat(false);
                break;

            case LEFT_AISLE:
            case RIGHT_AISLE:

                seat.setWindowSeat(false);
                seat.setAisleSeat(true);
                break;

            default:

                seat.setWindowSeat(false);
                seat.setAisleSeat(false);
        }
    }

}