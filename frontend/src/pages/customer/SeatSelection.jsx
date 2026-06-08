import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

import {
  FaArrowLeft,
  FaBus,
  FaCouch,
  FaLock,
  FaCheck,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function SeatSelection() {
  const navigate = useNavigate();
  const { id } = useParams();

  const seatPrice = 500;

  const buses = [
    {
      id: 1,
      name: "Shivneri Travels",
      route: "Pune → Latur",
      date: "20 Apr 2026",
    },
    {
      id: 2,
      name: "Express Travels",
      route: "Pune → Latur",
      date: "20 Apr 2026",
    },
    {
      id: 3,
      name: "Sai Ganesh Travels",
      route: "Pune → Latur",
      date: "20 Apr 2026",
    },
  ];

  const bus =
    buses.find((b) => b.id === Number(id)) ||
    buses[0];

  const [boarding, setBoarding] =
    useState("Pune Station");

  const [dropping, setDropping] =
    useState("Latur Stand");

  const bookedSeats = [
    "A1",
    "B3",
    "D2",
    "E4",
    "F3",
  ];

  const [selectedSeats, setSelectedSeats] =
    useState([]);

  const rows = ["A", "B", "C", "D", "E", "F"];

  const toggleSeat = (seat) => {
    if (bookedSeats.includes(seat)) return;

    if (selectedSeats.includes(seat)) {
      setSelectedSeats(
        selectedSeats.filter(
          (s) => s !== seat
        )
      );
    } else {
      setSelectedSeats([
        ...selectedSeats,
        seat,
      ]);
    }
  };

  const totalAmount =
    selectedSeats.length * seatPrice;

  const renderSeat = (seat) => {
    const booked =
      bookedSeats.includes(seat);

    const selected =
      selectedSeats.includes(seat);

    return (
      <button
        key={seat}
        disabled={booked}
        onClick={() => toggleSeat(seat)}
        className={`
          relative
          w-16 h-16 md:w-20 md:h-20
          rounded-t-xl rounded-b-md
          border-2
          transition-all duration-200
          flex flex-col items-center justify-center
          shadow-sm

          ${
            booked
              ? "bg-slate-200 border-slate-300 cursor-not-allowed opacity-75"
              : selected
              ? "bg-blue-600 border-blue-700 text-white scale-105 shadow-lg"
              : "bg-green-50 border-green-400 text-green-700 hover:scale-105 hover:shadow-md"
          }
        `}
      >
        {booked ? (
          <>
            <FaLock className="text-lg" />
            <span className="text-xs font-bold mt-1">
              {seat}
            </span>
          </>
        ) : selected ? (
          <>
            <FaCheck className="text-lg" />
            <span className="text-xs font-bold mt-1">
              {seat}
            </span>
          </>
        ) : (
          <>
            <FaCouch className="text-lg" />
            <span className="text-xs font-bold mt-1">
              {seat}
            </span>
          </>
        )}
      </button>
    );
  };

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-6">

        <div className="max-w-5xl mx-auto">

          {/* Back Button */}

          <button
            onClick={() =>
              navigate(`/bus-details/${id}`)
            }
            className="flex items-center gap-2 text-blue-600 font-semibold mb-5 hover:text-blue-700"
          >
            <FaArrowLeft />
            Back to Bus Details
          </button>

          {/* Main Card */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-6">

            {/* Bus Info */}

            <div className="text-center border-b pb-5">

              <h2 className="text-3xl font-black text-slate-900">
                {bus.name}
              </h2>

              <p className="text-slate-600 mt-2">
                {bus.route}
              </p>

              <p className="text-slate-500">
                {bus.date}
              </p>

            </div>

            {/* Boarding + Dropping */}

            <div className="grid md:grid-cols-2 gap-5 mt-6">

              <div>

                <label className="block text-sm font-semibold mb-2">
                  Boarding Point
                </label>

                <select
                  value={boarding}
                  onChange={(e) =>
                    setBoarding(
                      e.target.value
                    )
                  }
                  className="w-full h-12 px-3 border border-slate-300 rounded-xl"
                >
                  <option>Pune Station</option>
                  <option>Swargate</option>
                  <option>Narhe</option>
                  <option>Katraj</option>
                </select>

              </div>

              <div>

                <label className="block text-sm font-semibold mb-2">
                  Dropping Point
                </label>

                <select
                  value={dropping}
                  onChange={(e) =>
                    setDropping(
                      e.target.value
                    )
                  }
                  className="w-full h-12 px-3 border border-slate-300 rounded-xl"
                >
                  <option>Ahmedpur</option>
                  <option>Ausa Road</option>
                  <option>Nilanga</option>
                  <option>Latur Stand</option>
                </select>

              </div>

            </div>

            {/* Seat Layout */}

            <div className="mt-8 border rounded-3xl overflow-hidden">

              <div className="bg-slate-50 border-b px-6 py-4">

                <div className="flex justify-between items-center">

                  <h3 className="font-bold text-lg">
                    Seat Layout
                  </h3>

                  <div className="flex items-center gap-2">
                    <FaBus className="text-blue-600" />
                    <span className="font-semibold">
                      Driver
                    </span>
                  </div>

                </div>

              </div>

              <div className="p-8">

                <div className="max-w-2xl mx-auto">

                  {rows.map((row) => (
                    <div
                      key={row}
                      className="flex justify-center items-center gap-10 mb-5"
                    >

                      {/* Left Side */}

                      <div className="flex gap-4">

                        {renderSeat(`${row}1`)}

                        {renderSeat(`${row}2`)}

                      </div>

                      {/* Aisle */}

                      <div className="w-12"></div>

                      {/* Right Side */}

                      <div className="flex gap-4">

                        {renderSeat(`${row}3`)}

                        {renderSeat(`${row}4`)}

                      </div>

                    </div>
                  ))}

                </div>

              </div>

            </div>

            {/* Legend */}

<div className="flex flex-wrap justify-center gap-10 mt-8">

  {/* Available */}

  <div className="flex items-center gap-3">

    <div className="w-10 h-10 rounded-xl border-2 border-green-400 bg-green-50 flex items-center justify-center">

      <FaCouch className="text-green-600" />

    </div>

    <span className="font-medium text-slate-700">
      Available
    </span>

  </div>

  {/* Selected */}

  <div className="flex items-center gap-3">

    <div className="w-10 h-10 rounded-xl bg-blue-600 flex items-center justify-center">

      <FaCheck className="text-white" />

    </div>

    <span className="font-medium text-slate-700">
      Selected
    </span>

  </div>

  {/* Booked */}

  <div className="flex items-center gap-3">

    <div className="w-10 h-10 rounded-xl bg-slate-300 flex items-center justify-center">

      <FaLock className="text-slate-700" />

    </div>

    <span className="font-medium text-slate-700">
      Booked
    </span>

  </div>

</div>
            {/* Summary */}

            <div className="mt-8 bg-gradient-to-r from-blue-50 to-indigo-50 rounded-3xl border p-6">

              <div className="grid md:grid-cols-2 gap-6">

                <div>

                  <p className="text-slate-500 text-sm font-medium">
                    Selected Seats
                  </p>

                  <div className="flex flex-wrap gap-2 mt-3">

                    {selectedSeats.length > 0 ? (
                      selectedSeats.map(
                        (seat) => (
                          <span
                            key={seat}
                            className="px-3 py-1 bg-blue-600 text-white rounded-lg text-sm font-semibold"
                          >
                            {seat}
                          </span>
                        )
                      )
                    ) : (
                      <span className="text-slate-500">
                        No Seat Selected
                      </span>
                    )}

                  </div>

                </div>

                <div>

                  <p className="text-slate-500 text-sm font-medium">
                    Total Amount
                  </p>

                  <p className="text-4xl font-black text-green-600 mt-2">
                    ₹{totalAmount}
                  </p>

                  <p className="text-sm text-slate-500">
                    ₹500 × {selectedSeats.length} seat(s)
                  </p>

                </div>

              </div>

            </div>

            {/* Continue */}

            <div className="mt-6 flex justify-end">

              <button
                disabled={
                  selectedSeats.length === 0
                }
                onClick={() =>
                  navigate(
                    "/passenger-details", {
  state: {
    bus,
    selectedSeats,
    boarding,
    dropping,
    totalAmount,
  },
})
                }
                className="
                  px-8 py-3
                  rounded-xl
                  font-bold
                  text-white
                  bg-blue-600
                  hover:bg-blue-700
                  transition
                  shadow-md
                  disabled:bg-slate-300
                  disabled:cursor-not-allowed
                "
              >
                Continue
              </button>

            </div>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}