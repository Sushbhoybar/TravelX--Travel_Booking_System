import feedbacks from "../../data/feedback";
import "../../styles/admin.css";
import Navbar from "../../components/Navbar";

function ViewFeedback() {
  return (
    <>
      <Navbar />

      <div className="container py-5">

        <h2 className="text-center text-primary fw-bold mb-5">
          ⭐ Passenger Feedback
        </h2>

        <div className="row">

          {feedbacks.map((feedback) => (
            <div className="col-md-4 mb-4" key={feedback.id}>

              <div className="feedback-card">

                <h5>{feedback.name}</h5>

                <div className="mb-2">
                  ⭐ {feedback.rating}/5
                </div>

                <p>
                  "{feedback.comment}"
                </p>

                <small className="text-muted">
                  {feedback.date}
                </small>

              </div>

            </div>
          ))}

        </div>

      </div>
    </>
  );
}

export default ViewFeedback;