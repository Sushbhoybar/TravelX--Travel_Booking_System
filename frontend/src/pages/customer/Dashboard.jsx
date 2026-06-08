import React from "react";
import { useNavigate } from "react-router-dom";

import {
  FaBus,
  FaTicketAlt,
  FaUser,
  FaHeadset,
  FaArrowRight,
} from "react-icons/fa";

export default function Dashboard() {
  const navigate = useNavigate();

  const cards = [
    {
      title: "Search Bus",
      icon: <FaBus />,
      color: "text-blue-600",
      route: "/search-bus",
    },
    {
      title: "My Bookings",
      icon: <FaTicketAlt />,
      color: "text-green-600",
      route: "/booking-history",
    },
    {
      title: "Profile",
      icon: <FaUser />,
      color: "text-purple-600",
      route: "/profile",
    },
    {
      title: "Support",
      icon: <FaHeadset />,
      color: "text-orange-500",
      route: "/support",
    },
  ];

  return (
    <div className="min-h-screen bg-slate-100 px-4 py-6">

      <div className="max-w-6xl mx-auto">

        {/* Logo */}

        <div className="text-center mb-8">

          <h1 className="text-4xl font-black text-slate-900">
            TravelX
          </h1>

        </div>

        {/* Hero */}

        <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-8 mb-6">

          <div className="flex flex-col lg:flex-row justify-between items-center gap-6">

            <div>

              <h2 className="text-4xl font-black text-slate-900">
                Welcome Back, Sushil 👋
              </h2>

              <p className="text-slate-600 mt-3 text-lg">
                Plan your next journey with comfort and ease.
              </p>

            </div>

            <button
              onClick={() => navigate("/search-bus")}
              className="bg-blue-600 hover:bg-blue-700 text-white px-8 py-4 rounded-2xl font-bold flex items-center gap-3"
            >
              Search Bus
              <FaArrowRight />
            </button>

          </div>

        </div>

        {/* Stats */}

        <div className="grid md:grid-cols-2 gap-5 mb-6">

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-6">

            <p className="text-slate-500 font-medium">
              Total Trips
            </p>

            <h3 className="text-5xl font-black mt-2">
              08
            </h3>

          </div>

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-6">

            <p className="text-slate-500 font-medium">
              Active Tickets
            </p>

            <h3 className="text-5xl font-black mt-2">
              02
            </h3>

          </div>

        </div>

        {/* Upcoming Journey */}

        <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-6 mb-6">

          <div className="flex justify-between items-center mb-5">

            <h3 className="text-2xl font-bold">
              Upcoming Journey
            </h3>

            <button
              onClick={() => navigate("/booking-history")}
              className="text-blue-600 font-semibold"
            >
              View All
            </button>

          </div>

          <div className="grid lg:grid-cols-4 gap-5 items-center">

            <div>

              <p className="text-slate-500">
                Route
              </p>

              <p className="font-bold text-xl">
                Pune → Latur
              </p>

            </div>

            <div>

              <p className="text-slate-500">
                Date
              </p>

              <p className="font-bold">
                20 Apr 2026
              </p>

            </div>

            <div>

              <p className="text-slate-500">
                Bus
              </p>

              <p className="font-bold">
                Shivneri Travels
              </p>

            </div>

            <button
              className="bg-slate-900 text-white py-3 rounded-xl font-semibold"
            >
              View Ticket
            </button>

          </div>

        </div>

        {/* Quick Actions */}

        <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-5">

          {cards.map((card, index) => (
            <div
              key={index}
              onClick={() => navigate(card.route)}
              className="bg-white rounded-3xl border border-slate-200 shadow-md p-6 cursor-pointer hover:shadow-xl hover:-translate-y-1 transition"
            >

              <div
                className={`text-5xl mb-4 ${card.color}`}
              >
                {card.icon}
              </div>

              <h3 className="text-xl font-bold">
                {card.title}
              </h3>

              <p className="text-slate-500 mt-2">
                Open {card.title}
              </p>

            </div>
          ))}

        </div>

      </div>

    </div>
  );
}