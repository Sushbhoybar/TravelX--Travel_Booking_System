import React, { useState } from "react";

import {
  FaHeadset,
  FaPhoneAlt,
  FaEnvelope,
  FaTicketAlt,
  FaChevronDown,
  FaChevronUp,
  FaPaperPlane,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function Support() {
  const [openFAQ, setOpenFAQ] =
    useState(null);

  const [subject, setSubject] =
    useState("");

  const [message, setMessage] =
    useState("");

  const faqs = [
    {
      question:
        "How can I cancel my booking?",
      answer:
        "Go to Booking History and click the Cancel button for eligible bookings.",
    },
    {
      question:
        "How do I check my booking status?",
      answer:
        "You can track booking status from the Booking History page.",
    },
    {
      question:
        "When will I receive my ticket?",
      answer:
        "Your ticket is generated immediately after successful payment.",
    },
    {
      question:
        "Can I change passenger details after booking?",
      answer:
        "Passenger details cannot be modified once the booking is confirmed.",
    },
    {
      question:
        "How can I contact customer support?",
      answer:
        "You can call, email, or submit a support ticket below.",
    },
  ];

  const handleSubmit = (e) => {
    e.preventDefault();

    alert(
      "Support Ticket Submitted Successfully!"
    );

    setSubject("");
    setMessage("");
  };

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-8">

        <div className="max-w-6xl mx-auto">

          {/* Hero Section */}

          <div className="bg-gradient-to-r from-blue-600 to-blue-700 rounded-3xl shadow-lg p-8 text-white">

            <div className="flex items-center gap-4">

              <div className="w-16 h-16 bg-white/20 rounded-2xl flex items-center justify-center">

                <FaHeadset className="text-3xl" />

              </div>

              <div>

                <h1 className="text-3xl font-black">
                  Customer Support
                </h1>

                <p className="text-blue-100 mt-2">
                  We're here to help you with your bookings and travel experience.
                </p>

              </div>

            </div>

          </div>

          {/* Quick Help Cards */}

          <div className="grid md:grid-cols-3 gap-5 mt-6">

            <div className="bg-white rounded-3xl border border-slate-200 shadow-sm p-6">

              <div className="w-14 h-14 bg-blue-100 rounded-2xl flex items-center justify-center mb-4">

                <FaPhoneAlt className="text-blue-600 text-xl" />

              </div>

              <h3 className="font-bold text-lg">
                Call Support
              </h3>

              <p className="text-slate-500 mt-2">
                +91 9876543210
              </p>

              <p className="text-sm text-slate-400 mt-1">
                Available 24×7
              </p>

            </div>

            <div className="bg-white rounded-3xl border border-slate-200 shadow-sm p-6">

              <div className="w-14 h-14 bg-green-100 rounded-2xl flex items-center justify-center mb-4">

                <FaEnvelope className="text-green-600 text-xl" />

              </div>

              <h3 className="font-bold text-lg">
                Email Support
              </h3>

              <p className="text-slate-500 mt-2">
                support@travelx.com
              </p>

              <p className="text-sm text-slate-400 mt-1">
                Response within 24 hours
              </p>

            </div>

            <div className="bg-white rounded-3xl border border-slate-200 shadow-sm p-6">

              <div className="w-14 h-14 bg-orange-100 rounded-2xl flex items-center justify-center mb-4">

                <FaTicketAlt className="text-orange-600 text-xl" />

              </div>

              <h3 className="font-bold text-lg">
                Raise Ticket
              </h3>

              <p className="text-slate-500 mt-2">
                Get help for booking issues
              </p>

              <p className="text-sm text-slate-400 mt-1">
                Fast support response
              </p>

            </div>

          </div>

          {/* FAQ Section */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md mt-8 overflow-hidden">

            <div className="px-6 py-5 border-b bg-slate-50">

              <h2 className="text-2xl font-bold">
                Frequently Asked Questions
              </h2>

            </div>

            <div>

              {faqs.map((faq, index) => (

                <div
                  key={index}
                  className="border-b border-slate-200"
                >

                  <button
                    onClick={() =>
                      setOpenFAQ(
                        openFAQ === index
                          ? null
                          : index
                      )
                    }
                    className="
                      w-full
                      flex
                      justify-between
                      items-center
                      px-6
                      py-5
                      text-left
                      hover:bg-slate-50
                    "
                  >

                    <span className="font-semibold text-slate-800">
                      {faq.question}
                    </span>

                    {openFAQ === index ? (
                      <FaChevronUp />
                    ) : (
                      <FaChevronDown />
                    )}

                  </button>

                  {openFAQ === index && (

                    <div className="px-6 pb-5 text-slate-600">

                      {faq.answer}

                    </div>

                  )}

                </div>

              ))}

            </div>

          </div>

          {/* Support Form */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md mt-8 overflow-hidden">

            <div className="px-6 py-5 border-b bg-slate-50">

              <h2 className="text-2xl font-bold">
                Submit Support Ticket
              </h2>

            </div>

            <form
              onSubmit={handleSubmit}
              className="p-6"
            >

              <div className="mb-5">

                <label className="block font-semibold mb-2">
                  Subject
                </label>

                <input
                  type="text"
                  value={subject}
                  onChange={(e) =>
                    setSubject(
                      e.target.value
                    )
                  }
                  placeholder="Enter subject"
                  className="
                    w-full
                    border
                    border-slate-300
                    rounded-xl
                    px-4
                    py-3
                    outline-none
                    focus:ring-2
                    focus:ring-blue-200
                  "
                  required
                />

              </div>

              <div>

                <label className="block font-semibold mb-2">
                  Description
                </label>

                <textarea
                  rows="6"
                  value={message}
                  onChange={(e) =>
                    setMessage(
                      e.target.value
                    )
                  }
                  placeholder="Describe your issue..."
                  className="
                    w-full
                    border
                    border-slate-300
                    rounded-xl
                    px-4
                    py-3
                    resize-none
                    outline-none
                    focus:ring-2
                    focus:ring-blue-200
                  "
                  required
                />

              </div>

              <button
                type="submit"
                className="
                  mt-6
                  bg-blue-600
                  hover:bg-blue-700
                  text-white
                  px-6
                  py-3
                  rounded-xl
                  font-semibold
                  flex
                  items-center
                  gap-2
                "
              >
                <FaPaperPlane />
                Submit Ticket
              </button>

            </form>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}