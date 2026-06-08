import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import {
  FaUser,
  FaEnvelope,
  FaPhone,
  FaVenusMars,
  FaLock,
  FaEye,
  FaEyeSlash,
} from "react-icons/fa";

export default function Register() {
  const navigate = useNavigate();

  const [showPassword, setShowPassword] =
    useState(false);

  const [showConfirmPassword, setShowConfirmPassword] =
    useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    alert("Registration Successful!");

    navigate("/");
  };

  return (
    <div className="fixed inset-0 bg-slate-100 overflow-y-auto">

      <div className="max-w-md mx-auto my-4 bg-white rounded-2xl shadow-xl p-4">

        {/* Header */}

        <div className="text-center mb-4">

          <h1 className="!text-2xl !font-black !text-slate-900 !m-0">
            TravelX
          </h1>

          <p className="text-slate-500 text-sm mt-1">
            Create Your Account
          </p>

        </div>

        <form
          onSubmit={handleSubmit}
          className="space-y-2"
        >

          {/* Full Name */}

          <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

            <div className="bg-slate-50 px-3 py-2.5 text-blue-600">
              <FaUser />
            </div>

            <input
              type="text"
              placeholder="Full Name"
              required
              className="flex-1 px-3 py-2.5 outline-none text-sm text-slate-800"
            />

          </div>

          {/* Email */}

          <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

            <div className="bg-slate-50 px-3 py-2.5 text-blue-600">
              <FaEnvelope />
            </div>

            <input
              type="email"
              placeholder="Email Address"
              required
              className="flex-1 px-3 py-2.5 outline-none text-sm text-slate-800"
            />

          </div>

          {/* Phone */}

          <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

            <div className="bg-slate-50 px-3 py-2.5 text-blue-600">
              <FaPhone />
            </div>

            <input
              type="tel"
              placeholder="Phone Number"
              required
              className="flex-1 px-3 py-2.5 outline-none text-sm text-slate-800"
            />

          </div>

          {/* Gender */}

          <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

            <div className="bg-slate-50 px-3 py-2.5 text-blue-600">
              <FaVenusMars />
            </div>

            <select
              required
              className="flex-1 px-3 py-2.5 outline-none text-sm text-slate-800 bg-white"
            >
              <option value="">
                Select Gender
              </option>

              <option value="Male">
                Male
              </option>

              <option value="Female">
                Female
              </option>

              <option value="Other">
                Other
              </option>

            </select>

          </div>

          {/* Password */}

          <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

            <div className="bg-slate-50 px-3 py-2.5 text-blue-600">
              <FaLock />
            </div>

            <input
              type={
                showPassword
                  ? "text"
                  : "password"
              }
              placeholder="Password"
              required
              className="flex-1 px-3 py-2.5 outline-none text-sm text-slate-800"
            />

            <button
              type="button"
              onClick={() =>
                setShowPassword(
                  !showPassword
                )
              }
              className="px-3 text-slate-500"
            >
              {showPassword
                ? <FaEyeSlash />
                : <FaEye />}
            </button>

          </div>

          {/* Confirm Password */}

          <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

            <div className="bg-slate-50 px-3 py-2.5 text-blue-600">
              <FaLock />
            </div>

            <input
              type={
                showConfirmPassword
                  ? "text"
                  : "password"
              }
              placeholder="Confirm Password"
              required
              className="flex-1 px-3 py-2.5 outline-none text-sm text-slate-800"
            />

            <button
              type="button"
              onClick={() =>
                setShowConfirmPassword(
                  !showConfirmPassword
                )
              }
              className="px-3 text-slate-500"
            >
              {showConfirmPassword
                ? <FaEyeSlash />
                : <FaEye />}
            </button>

          </div>

          {/* Register Button */}

          <button
            type="submit"
            className="w-full bg-blue-600 hover:bg-blue-700 transition text-white py-2.5 rounded-xl font-semibold mt-2"
          >
            Create Account
          </button>

          {/* Divider */}

          <div className="flex items-center my-3">

            <div className="flex-1 h-px bg-slate-300"></div>

            <span className="px-3 text-slate-500 text-xs">
              OR
            </span>

            <div className="flex-1 h-px bg-slate-300"></div>

          </div>

          {/* Login Link */}

          <p className="text-center text-slate-600 text-sm">

            Already have an account?{" "}

            <Link
              to="/login"
              className="text-blue-600 font-semibold hover:underline"
            >
              Login
            </Link>

          </p>

        </form>

      </div>

    </div>
  );
}