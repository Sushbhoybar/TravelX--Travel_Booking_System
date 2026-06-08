import React from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import {
  FaSignOutAlt,
  FaHome,
  FaTicketAlt,
  FaHeadset,
  FaUser,
} from "react-icons/fa";

export default function Header() {
  const navigate = useNavigate();
  const location = useLocation();

  const navButtonClass = (path) =>
    `flex items-center gap-2 px-4 py-2 rounded-xl text-sm font-semibold transition ${
      location.pathname === path
        ? "bg-blue-600 text-white"
        : "bg-slate-100 text-slate-700 hover:bg-slate-200"
    }`;

  return (
    <div className="px-4 pt-4">
      <div className="bg-white rounded-2xl shadow-sm border border-slate-200 px-4 py-3">

        <div className="flex flex-col lg:flex-row items-center justify-between gap-4">

          {/* Logout */}

          <button
            onClick={() => navigate("/login")}
            className="flex items-center gap-2 px-4 py-2 rounded-xl bg-red-50 text-red-600 hover:bg-red-100 font-semibold transition"
          >
            <FaSignOutAlt />
            Logout
          </button>


          {/* Navigation */}

          <div className="flex flex-wrap justify-center gap-2">

            <Link
              to="/dashboard"
              className={navButtonClass("/dashboard")}
            >
              <FaHome />
              Home
            </Link>

            <Link
              to="/booking-history"
              className={navButtonClass("/booking-history")}
            >
              <FaTicketAlt />
              Booking
            </Link>

            <Link
              to="/support"
              className={navButtonClass("/support")}
            >
              <FaHeadset />
              Support
            </Link>

            <Link
              to="/profile"
              className={navButtonClass("/profile")}
            >
              <FaUser />
              Profile
            </Link>

          </div>

        </div>

      </div>
    </div>
  );
}