import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import {
  FaExchangeAlt,
  FaSearch,
  FaSignOutAlt,
} from "react-icons/fa";

export default function SearchBus() {
  const navigate = useNavigate();

  const [from, setFrom] = useState("");
  const [to, setTo] = useState("");

  const [day, setDay] = useState("");
  const [month, setMonth] = useState("");
  const [year, setYear] = useState("");

  const swapCities = () => {
    const temp = from;
    setFrom(to);
    setTo(temp);
  };

  const handleSearch = (e) => {
    e.preventDefault();

    if (!from || !to || !day || !month || !year) {
      alert("Please fill all fields");
      return;
    }

    navigate("/bus-list");
  };

  return (
    <div
      className="min-h-screen bg-slate-100 flex flex-col"
      style={{
        width: "100vw",
        maxWidth: "100vw",
        position: "relative",
        left: "50%",
        transform: "translateX(-50%)",
      }}
    >
      {/* Header */}

      <div className="px-4 pt-4">

        <div className="bg-white rounded-xl shadow-sm border border-slate-200 px-4 py-2">

          <div className="flex items-center justify-between">

            <button
              onClick={() => navigate("/")}
              className="flex items-center gap-2 text-red-600 text-sm font-semibold"
            >
              <FaSignOutAlt />
              Logout
            </button>

            <div className="text-black font-black text-xl">
              TravelX
            </div>

            <div className="flex items-center gap-3 md:gap-6">

              <Link
                to="/booking-history"
                className="text-sm font-medium text-slate-700 hover:text-blue-600"
              >
                Booking
              </Link>

              <Link
                to="/support"
                className="text-sm font-medium text-slate-700 hover:text-blue-600"
              >
                Help
              </Link>

              <Link
                to="/profile"
                className="text-sm font-medium text-slate-700 hover:text-blue-600"
              >
                Profile
              </Link>

            </div>

          </div>

        </div>

      </div>

      {/* Main Content */}

      <div className="flex-1 flex items-center justify-center px-4 py-6">

        <div className="w-full max-w-md bg-white rounded-2xl shadow-md border border-slate-200 p-6">

          <h2 className="text-center text-2xl font-bold text-black mb-6">
            Search Bus
          </h2>

          <form
            onSubmit={handleSearch}
            className="space-y-4"
          >

            {/* FROM */}

            <div>

              <label className="block text-sm font-semibold mb-2">
                From
              </label>

              <select
                value={from}
                onChange={(e) => setFrom(e.target.value)}
                className="w-full h-12 border border-slate-300 rounded-xl px-3"
              >
                <option value="">
                  Select Source
                </option>

                <option>Pune</option>
                <option>Mumbai</option>
                <option>Latur</option>
                <option>Nagpur</option>
                <option>Nashik</option>

              </select>

            </div>

            {/* SWAP */}

            <div className="flex justify-center">

              <button
                type="button"
                onClick={swapCities}
                className="w-10 h-10 rounded-full bg-slate-100 hover:bg-slate-200 flex items-center justify-center"
              >
                <FaExchangeAlt />
              </button>

            </div>

            {/* TO */}

            <div>

              <label className="block text-sm font-semibold mb-2">
                To
              </label>

              <select
                value={to}
                onChange={(e) => setTo(e.target.value)}
                className="w-full h-12 border border-slate-300 rounded-xl px-3"
              >
                <option value="">
                  Select Destination
                </option>

                <option>Pune</option>
                <option>Mumbai</option>
                <option>Latur</option>
                <option>Nagpur</option>
                <option>Nashik</option>

              </select>

            </div>

            {/* JOURNEY DATE */}

            <div>

              <label className="block text-sm font-semibold mb-2">
                Journey Date
              </label>

              <div className="grid grid-cols-3 gap-2">

                <select
                  value={day}
                  onChange={(e) => setDay(e.target.value)}
                  className="h-12 border border-slate-300 rounded-xl px-2"
                >
                  <option value="">
                    Day
                  </option>

                  {[...Array(31)].map((_, i) => (
                    <option key={i + 1}>
                      {i + 1}
                    </option>
                  ))}
                </select>

                <select
                  value={month}
                  onChange={(e) => setMonth(e.target.value)}
                  className="h-12 border border-slate-300 rounded-xl px-2"
                >
                  <option value="">
                    Month
                  </option>

                  <option>Jan</option>
                  <option>Feb</option>
                  <option>Mar</option>
                  <option>Apr</option>
                  <option>May</option>
                  <option>Jun</option>
                  <option>Jul</option>
                  <option>Aug</option>
                  <option>Sep</option>
                  <option>Oct</option>
                  <option>Nov</option>
                  <option>Dec</option>

                </select>

                <select
                  value={year}
                  onChange={(e) => setYear(e.target.value)}
                  className="h-12 border border-slate-300 rounded-xl px-2"
                >
                  <option value="">
                    Year
                  </option>

                  <option>2026</option>
                  <option>2027</option>
                  <option>2028</option>

                </select>

              </div>

            </div>

            {/* SEARCH BUTTON */}

            <button
              type="submit"
              className="w-full h-12 bg-blue-600 hover:bg-blue-700 text-white rounded-xl font-semibold flex items-center justify-center gap-2"
            >
              <FaSearch />
              Search Bus
            </button>

          </form>

        </div>

      </div>

      {/* Footer */}

      <footer className="bg-white border-t border-slate-200 py-3 text-center text-sm text-slate-500">
        © 2026 TravelX. All Rights Reserved.
      </footer>

    </div>
  );
}