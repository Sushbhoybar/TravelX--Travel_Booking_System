import { Link, useNavigate } from "react-router-dom";

function ChooseRegister() {
    const navigate = useNavigate();

    return (
        <div className="min-h-screen bg-[#f5f7fb] flex flex-col items-center px-5 py-12">
            <h2 className="text-2xl font-semibold text-gray-900 text-center ">
                Please choose how you want to register
            </h2>

            <hr />

            <div className="flex flex-row gap-10 ">
                {/* Customer Card */}
                <div className="max-w-[320px] min-h-[370px] bg-white border border-gray-300 rounded-xl px-7 py-8 text-center ">
                    <div className="w-[75px] h-[75px] bg-[#eef3ff] rounded-full mx-auto mb-5 flex items-center justify-center text-4xl">
                        👤
                    </div>

                    <h3 className="text-2xl font-bold text-gray-900 mb-5">
                        Register as Customer
                    </h3>

                    <div className="h-px bg-gray-300 mb-6"></div>

                    <p className="text-gray-600 text-base leading-7 min-h-[85px] mb-6">
                        Book tickets, manage bookings and enjoy a hassle-free travel
                        experience.
                    </p>

                    <button
                        onClick={() => navigate("/register/customer")}
                        className="rounded-full w-full h-12 bg-gray-900 text-white text-base font-semibold hover:bg-blue-700 transition"
                    >
                        Register as Customer
                    </button>
                </div>

                {/* Agent Card */}
                <div className="max-w-[320px] min-h-[370px] bg-white border border-gray-300 rounded-xl px-7 py-8 text-center">
                    <div className="w-[75px] h-[75px] bg-[#eef3ff] rounded-full mx-auto mb-5 flex items-center justify-center text-4xl">
                        👔
                    </div>

                    <h3 className="text-2xl font-bold text-gray-900 mb-5">
                        Register as <br></br>Agent
                    </h3>

                    <div className="h-px bg-gray-300 mb-6"></div>

                    <p className="text-gray-600 text-base leading-7 min-h-[85px] mb-6">
                        Add buses, manage routes, view bookings and grow your business.
                    </p>

                    <button
                        onClick={() => navigate("/register/agent")}
                        className="w-full h-12 bg-gray-900 text-white text-base font-semibold hover:bg-blue-700 transition"
                    >
                        Register as Agent
                    </button>
                </div>
            </div>

            <hr />

            <p className="text-gray-700 text-base mt-9">
                Already have an account?{" "}
                <Link to="/login" className="text-blue-700 font-semibold">
                    Login
                </Link>
            </p>
        </div>
    );
}

export default ChooseRegister;