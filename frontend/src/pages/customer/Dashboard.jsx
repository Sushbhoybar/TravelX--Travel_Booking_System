import React from "react";
import { useNavigate } from "react-router-dom";

import {
  FaSearch,
  FaBus,
  FaTicketAlt,
  FaUser,
  FaHeadset,
  FaSignOutAlt,
  FaArrowRight,
} from "react-icons/fa";

export default function Dashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
    navigate("/login");
  };

  return (
    <div className="fixed inset-0 bg-slate-100 overflow-y-auto">

      <div className="max-w-7xl mx-auto px-4 py-5">

        {/* Title */}

        <div className="text-center mb-6">

          <h1 className="!text-4xl !font-black !m-0 !text-slate-900">
            TravelX
          </h1>

        </div>

        {/* Welcome */}

        <div className="text-center mb-8">

          <h2 className="!text-5xl !font-black !text-slate-900 !m-0">
            Welcome, Sushil!
          </h2>

          <p className="text-slate-600 text-xl mt-3">
            Plan your journey and manage your bookings easily.
          </p>

        </div>

        {/* Search Banner */}

        

        {/* Four Cards */}

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-5 mb-6">

          {/* Search Bus */}

          <div
            onClick={() => navigate("/search-bus")}
            className="bg-white rounded-3xl border border-slate-200 shadow-md p-6 cursor-pointer hover:shadow-lg transition"
          >

            <div className="flex justify-center mb-4">

              <FaBus className="text-5xl text-blue-600" />

            </div>

            <h3 className="text-2xl font-bold text-center">
              Search Bus
            </h3>

            <p className="text-slate-600 text-center mt-3">
              Search buses by source,
              destination and date.
            </p>

          </div>

          {/* Bookings */}

          <div
            onClick={() => navigate("/my-bookings")}
            className="bg-white rounded-3xl border border-slate-200 shadow-md p-6 cursor-pointer hover:shadow-lg transition"
          >

            <div className="flex justify-center mb-4">

              <FaTicketAlt className="text-5xl text-green-600" />

            </div>

            <h3 className="text-2xl font-bold text-center">
              My Bookings
            </h3>

            <p className="text-slate-600 text-center mt-3">
              View bookings, tickets
              and journey details.
            </p>

          </div>

          {/* Profile */}

          <div
            onClick={() => navigate("/profile")}
            className="bg-white rounded-3xl border border-slate-200 shadow-md p-6 cursor-pointer hover:shadow-lg transition"
          >

            <div className="flex justify-center mb-4">

              <FaUser className="text-5xl text-purple-600" />

            </div>

            <h3 className="text-2xl font-bold text-center">
              Profile
            </h3>

            <p className="text-slate-600 text-center mt-3">
              View and update your
              personal information.
            </p>

          </div>

          {/* Support */}

          <div
            onClick={() => navigate("/support")}
            className="bg-white rounded-3xl border border-slate-200 shadow-md p-6 cursor-pointer hover:shadow-lg transition"
          >

            <div className="flex justify-center mb-4">

              <FaHeadset className="text-5xl text-orange-500" />

            </div>

            <h3 className="text-2xl font-bold text-center">
              Help & Support
            </h3>

            <p className="text-slate-600 text-center mt-3">
              Get help and contact
              customer support.
            </p>

          </div>

        </div>

        {/* Upcoming Journey */}

        <div className="bg-white rounded-3xl border border-slate-200 shadow-md p-6 mb-6">

          <div className="flex justify-between items-center border-b pb-4 mb-4">

            <h3 className="text-3xl font-bold text-slate-900">
              Upcoming Journey
            </h3>

            <button className="text-blue-600 font-semibold">
              View All Bookings
            </button>

          </div>

          <div className="flex flex-col lg:flex-row lg:items-center lg:justify-between gap-5">

            <div>

              <h4 className="text-2xl font-bold">
                Shivneri Travels
              </h4>

              <p className="text-slate-600 mt-1">
                Pune → Latur
              </p>

              <p className="text-slate-500">
                20 Apr 2026 | 10:00 AM
              </p>

            </div>

            <div>
              <p className="text-slate-500">
                PNR No.
              </p>
              <p className="font-bold">
                TX101
              </p>
            </div>

            <div>
              <p className="text-slate-500">
                Seats
              </p>
              <p className="font-bold">
                A1, A2
              </p>
            </div>

            <div>

              <span className="px-4 py-2 rounded-lg border font-semibold">
                Confirmed
              </span>

            </div>

            <button className="bg-slate-900 text-white px-6 py-3 rounded-xl font-semibold hover:bg-slate-800">
              View Details
            </button>

          </div>

        </div>

        {/* Logout */}

        <button
          onClick={handleLogout}
          className="w-full bg-white border border-slate-300 rounded-2xl py-4 font-bold text-xl flex justify-center items-center gap-3 hover:bg-slate-50"
        >

          <FaSignOutAlt />

          Logout

        </button>

      </div>

    </div>
  );
}