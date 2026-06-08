import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function AgentRegister() {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        agencyName: "",
        ownerName: "",
        email: "",
        phone: "",
        password: "",
        confirmPassword: "",
        businessType: "",
        address: "",
        city: "",
        state: "",
        pincode: "",
        gstNumber: "",
        panNumber: "",
        idProof: null,
    });

    const handleChange = (e) => {
        const { name, value, files } = e.target;

        setFormData({
            ...formData,
            [name]: files ? files[0] : value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (formData.password !== formData.confirmPassword) {
            alert("Password and Confirm Password do not match");
            return;
        }

        console.log("Agent Registration Data:", formData);
        alert("Agent registration submitted successfully!");

        navigate("/login");
    };

    return (
        <div className="min-h-screen bg-[#f5f7fb] flex justify-center items-start px-5 py-10 font-sans">
            <div className="w-full max-w-4xl bg-white border border-gray-300 rounded-xl px-8 py-9 shadow-md">
                {/* Icon */}
                <div className="w-[75px] h-[75px] bg-[#eef3ff] text-[#1d4ed8] rounded-full mx-auto mb-2 flex items-center justify-center text-4xl">
                    👔
                </div>

                {/* Heading */}
                <h2 className="text-center text-3xl font-bold text-gray-900">
                    Agent Registration
                </h2>

                <p className="text-center text-gray-600 text-sm mt-1 mb-2">
                    Create your agent account to add buses and manage trips
                </p>

                <form onSubmit={handleSubmit}>
                    {/* Basic Details */}
                    <h3 className="text-lg font-bold text-blue-700 border-b border-gray-300 pb-2 mb-2">
                        Basic Details
                    </h3>

                    <div className="grid grid-cols-1 md:grid-cols-2 gap-3">
                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Agency Name
                            </label>
                            <input
                                type="text"
                                name="agencyName"
                                value={formData.agencyName}
                                onChange={handleChange}
                                placeholder="Enter agency name"
                                required
                                className="w-full h-12 px-3 border border-gray-300 outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Owner Name
                            </label>
                            <input
                                type="text"
                                name="ownerName"
                                value={formData.ownerName}
                                onChange={handleChange}
                                placeholder="Enter owner name"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Email
                            </label>
                            <input
                                type="email"
                                name="email"
                                value={formData.email}
                                onChange={handleChange}
                                placeholder="example@gmail.com"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Phone Number
                            </label>
                            <input
                                type="tel"
                                name="phone"
                                value={formData.phone}
                                onChange={handleChange}
                                placeholder="Enter phone number"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Password
                            </label>
                            <input
                                type="password"
                                name="password"
                                value={formData.password}
                                onChange={handleChange}
                                placeholder="Create password"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Confirm Password
                            </label>
                            <input
                                type="password"
                                name="confirmPassword"
                                value={formData.confirmPassword}
                                onChange={handleChange}
                                placeholder="Confirm password"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>
                    </div>
                    <br></br>

                    {/* Business Details */}
                    <h3 className="text-lg font-bold text-blue-700 border-b border-gray-300 pb-2 mt-8 mb-5">
                        Business Details
                    </h3>

                    <div className="grid grid-cols-1 md:grid-cols-2 gap-3">
                        <div className="md:col-span-2">
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Business Type
                            </label>
                            <select
                                name="businessType"
                                value={formData.businessType}
                                onChange={handleChange}
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none bg-white focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            >
                                <option value="">Select business type</option>
                                <option value="Bus Operator">Bus Operator</option>
                                <option value="Travel Agency">Travel Agency</option>
                                <option value="Tour Operator">Tour Operator</option>
                                <option value="Individual Agent">Individual Agent</option>
                            </select>
                        </div>

                        <div className="md:col-span-2">
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Address
                            </label>
                            <textarea
                                name="address"
                                value={formData.address}
                                onChange={handleChange}
                                placeholder="Enter complete business address"
                                rows="2"
                                required
                                className="w-full px-3 py-3 border border-gray-300 rounded-md text-[15px] outline-none resize-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            ></textarea>
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                City
                            </label>
                            <input
                                type="text"
                                name="city"
                                value={formData.city}
                                onChange={handleChange}
                                placeholder="Enter city"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                State
                            </label>
                            <input
                                type="text"
                                name="state"
                                value={formData.state}
                                onChange={handleChange}
                                placeholder="Enter state"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Pincode
                            </label>
                            <input
                                type="text"
                                name="pincode"
                                value={formData.pincode}
                                onChange={handleChange}
                                placeholder="Enter pincode"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>
                    </div>
                    <br></br>

                    {/* Verification Details */}
                    <h3 className="text-lg font-bold text-blue-700 border-b border-gray-300 pb-2 mt-8 mb-5">
                        Verification Details
                    </h3>

                    <div className="grid grid-cols-1 md:grid-cols-2 gap-3">
                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                GST Number
                            </label>
                            <input
                                type="text"
                                name="gstNumber"
                                value={formData.gstNumber}
                                onChange={handleChange}
                                placeholder="Optional"
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                PAN Number
                            </label>
                            <input
                                type="text"
                                name="panNumber"
                                value={formData.panNumber}
                                onChange={handleChange}
                                placeholder="Optional"
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div className="md:col-span-2">
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Upload ID Proof
                            </label>
                            <input
                                type="file"
                                name="idProof"
                                onChange={handleChange}
                                accept=".jpg,.jpeg,.png,.pdf"
                                required
                                className="w-full border border-gray-300 rounded-md text-[15px] bg-white file:mr-4 file:h-12 file:px-4 file:border-0 file:bg-gray-900 file:text-white file:font-semibold hover:file:bg-blue-700"
                            />
                            <p className="text-xs text-gray-500 mt-2 mb-4">
                                Accepted formats: JPG, PNG, PDF
                            </p>
                        </div>
                    </div>

                    {/* Buttons */}
                    <button
                        type="submit"
                        className="w-full h-12 bg-gray-900 text-white rounded-md text-base font-semibold mt-8 hover:bg-blue-700 transition"
                    >
                        Register as Agent
                    </button>

                    <button
                        type="button"
                        onClick={() => navigate("/register")}
                        className="w-full h-11 bg-white text-gray-900 border border-gray-900 rounded-md text-[15px] font-semibold mt-3 hover:bg-[#eef3ff] hover:text-blue-700 hover:border-blue-700 transition"
                    >
                        Back
                    </button>
                </form>
                <br></br>

                <p className="text-center text-gray-700 text-sm mt-6">
                    Already have an account?{" "}
                    <Link
                        to="/login"
                        className="text-blue-700 font-semibold hover:underline"
                    >
                        Login
                    </Link>
                </p>
            </div>
        </div>
    );
}

export default AgentRegister;