import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  FaExchangeAlt,
  FaSearch,
  FaBus,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function SearchBus() {
  const navigate = useNavigate();

  const [tripData, setTripData] = useState({
    from: "",
    to: "",
    journeyDate: "",
  });

  const handleChange = (e) => {
    setTripData({
      ...tripData,
      [e.target.name]: e.target.value,
    });
  };

  const swapCities = () => {
    setTripData({
      ...tripData,
      from: tripData.to,
      to: tripData.from,
    });
  };

  const handleSearch = (e) => {
    e.preventDefault();

    if (
      !tripData.from ||
      !tripData.to ||
      !tripData.journeyDate
    ) {
      alert("Please fill all fields");
      return;
    }

    navigate("/bus-list");
  };

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-8">

        <div className="max-w-5xl mx-auto">

          {/* Hero Section */}

          <div className="text-center mb-8">

            <div className="flex justify-center mb-4">
              <FaBus className="text-5xl text-blue-600" />
            </div>

            <h1 className="text-4xl md:text-5xl font-black text-slate-900">
              Search Your Bus
            </h1>

            <p className="text-slate-600 text-lg mt-3">
              Find comfortable buses at the best prices for your journey.
            </p>

          </div>

          {/* Search Card */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-lg p-8">

            <form onSubmit={handleSearch}>

              <div className="grid lg:grid-cols-[1fr_auto_1fr_1fr] gap-4 items-end">

                {/* From */}

                <div>

                  <label className="block text-sm font-semibold text-gray-800 mb-2">
                    From
                  </label>

                  <select
                    name="from"
                    value={tripData.from}
                    onChange={handleChange}
                    className="w-full h-12 px-3 border border-gray-300 rounded-xl outline-none focus:border-blue-600 focus:ring-4 focus:ring-blue-100"
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

                {/* Swap */}

                <div className="flex justify-center">

                  <button
                    type="button"
                    onClick={swapCities}
                    className="w-12 h-12 rounded-full bg-blue-50 text-blue-600 hover:bg-blue-100 flex items-center justify-center transition"
                  >
                    <FaExchangeAlt />
                  </button>

                </div>

                {/* To */}

                <div>

                  <label className="block text-sm font-semibold text-gray-800 mb-2">
                    To
                  </label>

                  <select
                    name="to"
                    value={tripData.to}
                    onChange={handleChange}
                    className="w-full h-12 px-3 border border-gray-300 rounded-xl outline-none focus:border-blue-600 focus:ring-4 focus:ring-blue-100"
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

                {/* Journey Date */}

                <div>

                  <label className="block text-sm font-semibold text-gray-800 mb-2">
                    Journey Date
                  </label>

                  <input
                    type="date"
                    name="journeyDate"
                    value={tripData.journeyDate}
                    onChange={handleChange}
                    required
                    className="w-full h-12 px-3 border border-gray-300 rounded-xl text-[15px] outline-none cursor-pointer focus:border-blue-600 focus:ring-4 focus:ring-blue-100"
                  />

                </div>

              </div>

              {/* Search Button */}

              <div className="mt-6">

                <button
                  type="submit"
                  className="w-full h-14 bg-blue-600 hover:bg-blue-700 text-white rounded-xl font-bold text-lg flex items-center justify-center gap-3 transition"
                >
                  <FaSearch />
                  Search Available Buses
                </button>

              </div>

            </form>

          </div>

          {/* Info Cards */}

          <div className="grid md:grid-cols-3 gap-4 mt-8">

            <div className="bg-white rounded-2xl border border-slate-200 shadow-sm p-5">

              <h3 className="font-bold text-lg">
                1000+
              </h3>

              <p className="text-slate-600">
                Routes Available
              </p>

            </div>

            <div className="bg-white rounded-2xl border border-slate-200 shadow-sm p-5">

              <h3 className="font-bold text-lg">
                500+
              </h3>

              <p className="text-slate-600">
                Trusted Operators
              </p>

            </div>

            <div className="bg-white rounded-2xl border border-slate-200 shadow-sm p-5">

              <h3 className="font-bold text-lg">
                24×7
              </h3>

              <p className="text-slate-600">
                Customer Support
              </p>

            </div>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}