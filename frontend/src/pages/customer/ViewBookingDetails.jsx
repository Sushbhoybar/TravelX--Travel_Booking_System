import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

import {
  FaBus,
  FaMapMarkerAlt,
  FaUser,
  FaChair,
  FaRupeeSign,
  FaCreditCard,
  FaArrowLeft,
  FaSnowflake,
  FaWifi,
  FaBed,
  FaTint,
  FaChargingStation,
  FaFirstAid,
  FaTimes,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function ViewBookingDetails() {
  const navigate = useNavigate();
  const { id } = useParams();

  const [showCancelModal, setShowCancelModal] =
    useState(false);

  const [booking, setBooking] = useState({
    bookingId: id || "TX101",
    pnr: "TX101",

    busName: "Shivneri Travels",
    busType: "AC Sleeper",

    route: "Pune → Latur",

    date: "20-Apr-2026",

    departure: "10:00 AM",
    arrival: "06:00 PM",

    bookedOn: "15-Apr-2026 11:30 AM",

    seats: ["A1", "A2"],

    passengers: [
      "Rahul (25)",
      "Amit (22)",
    ],

    boarding:
      "Pune Station (10:00 AM)",

    dropping:
      "Latur Stand (06:00 PM)",

    amount: 1000,

    paymentMethod:
      "Credit Card (**** 3456)",

    status: "Confirmed",
  });

  const handleCancelBooking = () => {
    setBooking({
      ...booking,
      status: "Cancelled",
    });

    setShowCancelModal(false);
  };

  const getStatusStyle = (status) => {
    switch (status) {
      case "Confirmed":
        return "bg-green-100 text-green-700 border-green-300";

      case "Completed":
        return "bg-blue-100 text-blue-700 border-blue-300";

      case "Cancelled":
        return "bg-red-100 text-red-700 border-red-300";

      default:
        return "bg-slate-100 text-slate-700";
    }
  };

  const amenities = [
    {
      icon: <FaSnowflake />,
      name: "AC Sleeper",
    },
    {
      icon: <FaBed />,
      name: "2+1 Seating",
    },
    {
      icon: <FaWifi />,
      name: "Free Wi-Fi",
    },
    {
      icon: <FaTint />,
      name: "Water Bottle",
    },
    {
      icon: <FaChargingStation />,
      name: "Charging Point",
    },
    {
      icon: <FaFirstAid />,
      name: "First Aid Box",
    },
  ];

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-8">

        <div className="max-w-6xl mx-auto">

          {/* Main Card */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md overflow-hidden">

            {/* Header */}

            <div className="bg-blue-600 px-6 py-5">

              <div className="flex flex-col lg:flex-row justify-between gap-4">

                <div>

                  <h1 className="text-2xl font-black text-white">
                    Booking ID : {booking.bookingId}
                  </h1>

                  <p className="text-blue-100 mt-1">
                    PNR No : {booking.pnr}
                  </p>

                </div>

                <div>

                  <span
                    className={`
                      px-4
                      py-2
                      rounded-lg
                      border
                      font-semibold
                      bg-white
                      ${getStatusStyle(
                        booking.status
                      )}
                    `}
                  >
                    {booking.status}
                  </span>

                </div>

              </div>

            </div>

            <div className="p-6">

              {/* Bus Details */}

              <div className="grid lg:grid-cols-3 gap-6 border-b pb-6">

                <div className="flex gap-4">

                  <div className="w-20 h-20 bg-blue-50 rounded-2xl flex items-center justify-center">

                    <FaBus className="text-4xl text-blue-600" />

                  </div>

                  <div>

                    <h2 className="text-2xl font-bold">
                      {booking.busName}
                    </h2>

                    <p className="text-slate-500 mt-1">
                      {booking.busType}
                    </p>

                  </div>

                </div>

                <div className="space-y-3">

                  <p>
                    <strong>Route:</strong>{" "}
                    {booking.route}
                  </p>

                  <p>
                    <strong>Date:</strong>{" "}
                    {booking.date}
                  </p>

                  <p>
                    <strong>Time:</strong>{" "}
                    {booking.departure} -{" "}
                    {booking.arrival}
                  </p>

                </div>

                <div className="space-y-3">

                  <p>
                    <strong>Booked On:</strong>
                  </p>

                  <p>{booking.bookedOn}</p>

                </div>

              </div>

              {/* Journey Details */}

              <div className="mt-8">

                <h3 className="text-xl font-bold mb-5">
                  Journey Details
                </h3>

                <div className="grid md:grid-cols-2 gap-5">

                  <div className="flex gap-4">

                    <FaChair className="text-blue-600 text-xl mt-1" />

                    <div>

                      <p className="font-semibold">
                        Seats
                      </p>

                      <p>
                        {booking.seats.join(
                          ", "
                        )}
                      </p>

                    </div>

                  </div>

                  <div className="flex gap-4">

                    <FaUser className="text-blue-600 text-xl mt-1" />

                    <div>

                      <p className="font-semibold">
                        Passengers
                      </p>

                      <p>
                        {booking.passengers.join(
                          ", "
                        )}
                      </p>

                    </div>

                  </div>

                  <div className="flex gap-4">

                    <FaMapMarkerAlt className="text-green-600 text-xl mt-1" />

                    <div>

                      <p className="font-semibold">
                        Boarding Point
                      </p>

                      <p>
                        {booking.boarding}
                      </p>

                    </div>

                  </div>

                  <div className="flex gap-4">

                    <FaMapMarkerAlt className="text-red-600 text-xl mt-1" />

                    <div>

                      <p className="font-semibold">
                        Dropping Point
                      </p>

                      <p>
                        {booking.dropping}
                      </p>

                    </div>

                  </div>

                </div>

              </div>

              {/* Payment */}

              <div className="mt-8 border-t pt-6">

                <h3 className="text-xl font-bold mb-5">
                  Payment Details
                </h3>

                <div className="grid md:grid-cols-2 gap-5">

                  <div className="flex gap-4">

                    <FaRupeeSign className="text-green-600 text-xl mt-1" />

                    <div>

                      <p className="font-semibold">
                        Total Paid
                      </p>

                      <p className="text-2xl font-bold text-green-600">
                        ₹{booking.amount}
                      </p>

                    </div>

                  </div>

                  <div className="flex gap-4">

                    <FaCreditCard className="text-blue-600 text-xl mt-1" />

                    <div>

                      <p className="font-semibold">
                        Payment Method
                      </p>

                      <p>
                        {
                          booking.paymentMethod
                        }
                      </p>

                    </div>

                  </div>

                </div>

              </div>

              {/* Amenities */}

              <div className="mt-8 border-t pt-6">

                <h3 className="text-xl font-bold mb-5">
                  Bus Amenities
                </h3>

                <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-5">

                  {amenities.map(
                    (item, index) => (
                      <div
                        key={index}
                        className="text-center"
                      >
                        <div className="text-3xl text-blue-600 flex justify-center mb-2">
                          {item.icon}
                        </div>

                        <p className="text-sm font-medium">
                          {item.name}
                        </p>

                      </div>
                    )
                  )}

                </div>

              </div>

              {/* Note */}

              <div className="mt-8 bg-slate-50 border rounded-2xl p-4">

                <p className="text-slate-600">
                  Please reach the boarding
                  point at least 15 minutes
                  before departure.
                </p>

              </div>

              {/* Buttons */}

              <div className="mt-8 flex justify-between flex-wrap gap-4">

                <button
                  onClick={() =>
                    navigate(
                      "/booking-history"
                    )
                  }
                  className="
                    border
                    border-slate-300
                    px-6
                    py-3
                    rounded-xl
                    font-semibold
                    flex
                    items-center
                    gap-2
                  "
                >
                  <FaArrowLeft />
                  Back
                </button>

                {booking.status ===
                  "Confirmed" && (

                  <button
                    onClick={() =>
                      setShowCancelModal(
                        true
                      )
                    }
                    className="
                      bg-red-600
                      hover:bg-red-700
                      text-white
                      px-8
                      py-3
                      rounded-xl
                      font-semibold
                    "
                  >
                    Cancel Booking
                  </button>

                )}

              </div>

            </div>

          </div>

        </div>

      </div>

      {/* Cancel Modal */}

      {showCancelModal && (

        <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50">

          <div className="bg-white rounded-3xl p-6 max-w-md w-full mx-4">

            <div className="flex justify-between items-center mb-4">

              <h3 className="text-xl font-bold">
                Cancel Booking
              </h3>

              <button
                onClick={() =>
                  setShowCancelModal(
                    false
                  )
                }
              >
                <FaTimes />
              </button>

            </div>

            <p className="text-slate-600 mb-6">
              Are you sure you want to
              cancel this booking?
            </p>

            <div className="flex gap-3">

              <button
                onClick={() =>
                  setShowCancelModal(
                    false
                  )
                }
                className="
                  flex-1
                  border
                  border-slate-300
                  py-3
                  rounded-xl
                  font-semibold
                "
              >
                No
              </button>

              <button
                onClick={
                  handleCancelBooking
                }
                className="
                  flex-1
                  bg-red-600
                  text-white
                  py-3
                  rounded-xl
                  font-semibold
                "
              >
                Yes, Cancel
              </button>

            </div>

          </div>

        </div>

      )}

      <Footer />

    </div>
  );
}