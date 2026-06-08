import React from "react";
import { useNavigate, useParams } from "react-router-dom";

import {
  FaArrowLeft,
  FaBus,
  FaStar,
  FaMapMarkerAlt,
  FaCalendarAlt,
  FaClock,
  FaRupeeSign,
  FaSnowflake,
  FaWifi,
  FaBed,
  FaChargingStation,
  FaFirstAid,
  FaTint,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function BusDetails() {
  const navigate = useNavigate();
  const { id } = useParams();

  const buses = [
    {
      id: 1,
      name: "Shivneri Travels",
      type: "AC Sleeper",
      seating: "2+1 Seating",
      rating: 4.5,
      reviews: 120,
      route: "Pune → Latur",
      date: "20-Apr-2026",
      day: "Monday",
      departure: "10:00 AM",
      arrival: "06:00 PM",
      duration: "8h 00m",
      price: 500,
    },
    {
      id: 2,
      name: "Express Travels",
      type: "AC Semi Sleeper",
      seating: "2+2 Seating",
      rating: 4.2,
      reviews: 98,
      route: "Pune → Latur",
      date: "20-Apr-2026",
      day: "Monday",
      departure: "12:00 PM",
      arrival: "08:00 PM",
      duration: "8h 00m",
      price: 400,
    },
    {
      id: 3,
      name: "Sai Ganesh Travels",
      type: "AC Sleeper",
      seating: "2+1 Seating",
      rating: 4.6,
      reviews: 110,
      route: "Pune → Latur",
      date: "20-Apr-2026",
      day: "Monday",
      departure: "09:00 PM",
      arrival: "05:00 AM",
      duration: "8h 00m",
      price: 550,
    },
  ];

  const bus =
    buses.find((b) => b.id === Number(id)) || buses[0];

  const boardingPoints = [
    { time: "10:00 AM", point: "Pune Station" },
    { time: "10:30 AM", point: "Swargate" },
    { time: "11:00 AM", point: "Narhe" },
    { time: "11:30 AM", point: "Katraj" },
  ];

  const droppingPoints = [
    { time: "04:30 PM", point: "Ahmedpur" },
    { time: "05:00 PM", point: "Ausa Road" },
    { time: "05:30 PM", point: "Nilanga" },
    { time: "06:00 PM", point: "Latur Stand" },
  ];

  const amenities = [
    {
      icon: <FaSnowflake />,
      name: "Air Conditioner",
    },
    {
      icon: <FaBed />,
      name: "Sleeper Seats",
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

      <div className="flex-1 px-4 py-6">

        <div className="max-w-6xl mx-auto">

          {/* Back Button */}

          <button
            onClick={() => navigate("/bus-list")}
            className="mb-5 flex items-center gap-2 text-blue-600 font-semibold hover:text-blue-700"
          >
            <FaArrowLeft />
            Back to Bus List
          </button>

          {/* Main Card */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-6">

            {/* Top Section */}

            <div className="flex flex-col lg:flex-row lg:items-center lg:justify-between gap-5">

              <div className="flex items-center gap-4">

                <div className="w-20 h-20 rounded-2xl bg-blue-50 flex items-center justify-center">
                  <FaBus className="text-4xl text-blue-600" />
                </div>

                <div>

                  <div className="flex flex-wrap items-center gap-3">

                    <h2 className="text-3xl font-black">
                      {bus.name}
                    </h2>

                    <div className="flex items-center gap-1 bg-yellow-50 text-yellow-700 px-3 py-1 rounded-lg">
                      <FaStar />
                      {bus.rating}
                      <span className="text-slate-500">
                        ({bus.reviews})
                      </span>
                    </div>

                  </div>

                  <p className="text-slate-600 mt-2">
                    {bus.type} • {bus.seating}
                  </p>

                </div>

              </div>

            </div>

            {/* Journey Details */}

            <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-5 mt-8 border-y py-6">

              <div>

                <div className="flex items-center gap-2 mb-2">
                  <FaMapMarkerAlt className="text-blue-600" />
                  <span className="font-bold">
                    Route
                  </span>
                </div>

                <p>{bus.route}</p>

              </div>

              <div>

                <div className="flex items-center gap-2 mb-2">
                  <FaCalendarAlt className="text-blue-600" />
                  <span className="font-bold">
                    Date
                  </span>
                </div>

                <p>{bus.date}</p>
                <p>{bus.day}</p>

              </div>

              <div>

                <div className="flex items-center gap-2 mb-2">
                  <FaClock className="text-blue-600" />
                  <span className="font-bold">
                    Time
                  </span>
                </div>

                <p>
                  {bus.departure} - {bus.arrival}
                </p>

                <p className="text-slate-500">
                  ({bus.duration})
                </p>

              </div>

              <div>

                <div className="flex items-center gap-2 mb-2">
                  <FaRupeeSign className="text-blue-600" />
                  <span className="font-bold">
                    Price
                  </span>
                </div>

                <p className="text-2xl font-black text-green-600">
                  ₹{bus.price}
                </p>

                <p className="text-slate-500">
                  per seat
                </p>

              </div>

            </div>

            {/* Boarding & Dropping */}

            <div className="grid lg:grid-cols-2 gap-5 mt-6">

              <div className="border rounded-2xl p-5">

                <h3 className="font-bold text-xl mb-4">
                  Boarding Points
                </h3>

                <div className="space-y-4">

                  {boardingPoints.map((item, index) => (
                    <div
                      key={index}
                      className="flex gap-4"
                    >
                      <span className="font-semibold min-w-[90px]">
                        {item.time}
                      </span>

                      <span>{item.point}</span>
                    </div>
                  ))}

                </div>

              </div>

              <div className="border rounded-2xl p-5">

                <h3 className="font-bold text-xl mb-4">
                  Dropping Points
                </h3>

                <div className="space-y-4">

                  {droppingPoints.map((item, index) => (
                    <div
                      key={index}
                      className="flex gap-4"
                    >
                      <span className="font-semibold min-w-[90px]">
                        {item.time}
                      </span>

                      <span>{item.point}</span>
                    </div>
                  ))}

                </div>

              </div>

            </div>

            {/* Amenities */}

            <div className="mt-6 border rounded-2xl p-5">

              <h3 className="font-bold text-xl mb-5">
                Bus Amenities
              </h3>

              <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-5">

                {amenities.map((item, index) => (
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
                ))}

              </div>

            </div>

            {/* Bottom Fare */}

            <div className="mt-6 border rounded-2xl p-5 flex flex-col md:flex-row justify-between items-center gap-4">

              <div>

                <p className="text-slate-500">
                  Total Fare
                </p>

                <p className="text-4xl font-black text-green-600">
                  ₹{bus.price}
                </p>

                <p className="text-slate-500">
                  per seat
                </p>

              </div>

              <button
                onClick={() =>
                  navigate(`/seat-selection/${bus.id}`)
                }
                className="bg-slate-900 hover:bg-slate-800 text-white px-10 py-4 rounded-xl font-bold text-lg"
              >
                View Seats
              </button>

            </div>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}