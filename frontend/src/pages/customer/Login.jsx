import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import {
  FaEnvelope,
  FaLock,
  FaEye,
  FaEyeSlash,
} from "react-icons/fa";

export default function Login() {
  const navigate = useNavigate();

  const [showPassword, setShowPassword] =
    useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    navigate("/dashboard");
  };

  return (
    <div className="fixed inset-0 bg-slate-100 flex items-center justify-center p-4 overflow-auto">

      <div className="w-full max-w-md bg-white rounded-2xl shadow-xl p-5">

        {/* Header */}

        <div className="text-center mb-5">

          <h1 className="!text-3xl !font-black !text-slate-900 !m-0">
            TravelX
          </h1>

          <p className="text-slate-500 text-sm mt-2">
            Book Bus Tickets Easily & Securely
          </p>

        </div>

        <form onSubmit={handleSubmit}>

          {/* Email */}

          <div className="mb-3">

            <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

              <div className="bg-slate-50 px-4 py-3 text-blue-600">
                <FaEnvelope />
              </div>

              <input
                type="email"
                placeholder="Enter Email Address"
                required
                className="flex-1 px-4 py-3 outline-none text-slate-800 text-sm"
              />

            </div>

          </div>

          {/* Password */}

          <div className="mb-3">

            <div className="flex items-center border border-slate-300 rounded-xl overflow-hidden focus-within:ring-2 focus-within:ring-blue-200">

              <div className="bg-slate-50 px-4 py-3 text-blue-600">
                <FaLock />
              </div>

              <input
                type={
                  showPassword
                    ? "text"
                    : "password"
                }
                placeholder="Enter Password"
                required
                className="flex-1 px-4 py-3 outline-none text-slate-800 text-sm"
              />

              <button
                type="button"
                onClick={() =>
                  setShowPassword(
                    !showPassword
                  )
                }
                className="px-4 text-slate-500"
              >
                {showPassword
                  ? <FaEyeSlash />
                  : <FaEye />}
              </button>

            </div>

          </div>

          {/* Remember Me */}

          <div className="flex justify-between items-center mb-4 text-sm">

            <label className="flex items-center gap-2 text-slate-600">

              <input type="checkbox" className="accent-blue-600" />
              {" "}Remember Me
            </label>

            <button
              type="button"
              className="text-blue-600 hover:underline"
            >
              Forgot Password?
            </button>

          </div>

          {/* Login Button */}

          <button
            type="submit"
            className="w-full bg-blue-600 hover:bg-blue-700 transition text-white py-3 rounded-xl font-semibold"
          >
            Sign In
          </button>

          {/* Divider */}

          <div className="flex items-center my-4">

            <div className="flex-1 h-px bg-slate-300"></div>

            <span className="px-3 text-slate-500 text-sm">
              OR
            </span>

            <div className="flex-1 h-px bg-slate-300"></div>

          </div>

          {/* Register */}

          <p className="text-center text-slate-600 text-sm">

            New User?{" "}

            <Link
              to="/register"
              className="text-blue-600 font-semibold hover:underline"
            >
              Register Now
            </Link>

          </p>

        </form>

      </div>

    </div>
  );
}