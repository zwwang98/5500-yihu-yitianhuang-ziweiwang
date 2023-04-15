import React from "react";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";

const Home = () => {
  return (
    <div className="container">
      <nav>
        <Link to="/">Home</Link>
        <Link to="/ranking">Ranking</Link>
        <Link to="/suggestion">Suggestion</Link>
        <Link to="/recommendation">Recommendation</Link>
      </nav>
      <h1>Hello!</h1>
    </div>
  );
};

export default Home;
