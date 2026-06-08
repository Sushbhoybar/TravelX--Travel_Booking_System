import React from "react";
import { useNavigate } from "react-router-dom";
import {
  FaStar,
  FaSearch,
  FaBus,
  FaClock,
  FaArrowRight,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function BusList() {
  const navigate = useNavigate();

  const buses = [
    {
      id: 1,
      name: "Shivneri Travels",
      type: "AC Sleeper",
      route: "Pune → Latur",
      departure: "10:00 AM",
      arrival: "06:00 PM",
      duration: "8h",
      price: 500,
      rating: 4.5,
      reviews: 120,
      seats: 18,
    },
    {
      id: 2,
      name: "Express Travels",
      type: "AC Semi Sleeper",
      route: "Pune → Latur",
      departure: "12:00 PM",
      arrival: "08:00 PM",
      duration: "8h",
      price: 400,
      rating: 4.2,
      reviews: 98,
      seats: 12,
    },
    {
      id: 3,
      name: "Maharashtra Travels",
      type: "Non AC Seater",
      route: "Pune → Latur",
      departure: "02:00 PM",
      arrival: "10:00 PM",
      duration: "8h",
      price: 350,
      rating: 4.0,
      reviews: 76,
      seats: 8,
    },
    {
      id: 4,
      name: "Sai Ganesh Travels",
      type: "AC Sleeper",
      route: "Pune → Latur",
      departure: "09:00 PM",
      arrival: "05:00 AM",
      duration: "8h",
      price: 550,
      rating: 4.6,
      reviews: 110,
      seats: 21,
    },
  ];

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-6">

        <div className="max-w-6xl mx-auto">

          {/* Search Summary */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-5 mb-6">

            <div className="flex flex-col lg:flex-row justify-between items-center gap-4">

              <div>

                <h2 className="text-2xl font-black text-slate-900">
                  Pune → Latur
                </h2>

                <p className="text-slate-500 mt-1">
                  20 Apr 2026 • 4 Buses Available
                </p>

              </div>

              <button
                onClick={() => navigate("/search-bus")}
                className="bg-blue-600 hover:bg-blue-700 text-white px-5 py-3 rounded-xl font-semibold flex items-center gap-2 transition"
              >
                <FaSearch />
                Modify Search
              </button>

            </div>

          </div>

          {/* Bus Cards */}

          <div className="space-y-5">

            {buses.map((bus) => (
              <div
                key={bus.id}
                className="bg-white rounded-3xl border border-slate-200 shadow-md hover:shadow-xl transition duration-300 p-6"
              >

                <div className="grid lg:grid-cols-[2fr_2fr_1fr_1fr] gap-6 items-center">

                  {/* Bus Info */}

                  <div>

                    <div className="flex items-center gap-3 mb-2">

                      <FaBus className="text-blue-600 text-xl" />

                      <h3 className="text-xl font-bold text-slate-900">
                        {bus.name}
                      </h3>

                    </div>

                    <p className="text-slate-600">
                      {bus.type}
                    </p>

                    <div className="mt-3 inline-flex items-center gap-1 bg-yellow-50 text-yellow-700 px-3 py-1 rounded-lg text-sm font-semibold">
                      <FaStar />
                      {bus.rating}
                      <span className="text-slate-500 font-normal">
                        ({bus.reviews})
                      </span>
                    </div>

                  </div>

                  {/* Time */}

                  <div>

                    <div className="flex items-center justify-between">

                      <div>

                        <p className="text-2xl font-bold">
                          {bus.departure}
                        </p>

                        <p className="text-slate-500 text-sm">
                          Departure
                        </p>

                      </div>

                      <div className="px-3">

                        <FaArrowRight className="text-slate-400 text-xl" />

                        <p className="text-xs text-center text-slate-500 mt-1">
                          {bus.duration}
                        </p>

                      </div>

                      <div className="text-right">

                        <p className="text-2xl font-bold">
                          {bus.arrival}
                        </p>

                        <p className="text-slate-500 text-sm">
                          Arrival
                        </p>

                      </div>

                    </div>

                  </div>

                  {/* Price */}

                  <div className="text-center">

                    <p className="text-slate-500 text-sm">
                      Starting From
                    </p>

                    <p className="text-3xl font-black text-green-600">
                      ₹{bus.price}
                    </p>

                    <p className="text-xs text-slate-500">
                      Per Seat
                    </p>

                  </div>

                  {/* Action */}

                  <div className="text-center">

                    <div className="mb-3">

                      <span className="inline-block bg-green-100 text-green-700 px-3 py-1 rounded-full text-sm font-semibold">
                        {bus.seats} Seats Left
                      </span>

                    </div>

                    <button
                      onClick={() =>
                        navigate(`/bus-details/${bus.id}`)
                      }
                      className="w-full bg-blue-600 hover:bg-blue-700 text-white py-3 rounded-xl font-semibold transition"
                    >
                      View Details
                    </button>

                  </div>

                </div>

              </div>
            ))}

          </div>

          {/* Bottom Info */}

          <div className="mt-8 bg-white rounded-3xl border border-slate-200 shadow-sm p-5">

            <div className="flex items-center gap-3">

              <FaClock className="text-blue-600 text-xl" />

              <p className="text-slate-600">
                Showing available buses for your selected journey date.
                Prices may change based on seat availability.
              </p>

            </div>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}