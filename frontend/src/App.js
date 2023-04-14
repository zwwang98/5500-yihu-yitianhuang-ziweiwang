import React from "react";
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import "./App.css";
import Suggestion from "./Suggestion";
import Recommendation from "./Recommendation";
import "bootstrap/dist/css/bootstrap.css";

const Home = () => <h1>Hello!</h1>;
const Ranking = () => <h1>Ranking</h1>;
// const Suggestion = () => <h1>Suggestion</h1>;
// const Recommendation = () => <h1>Recommendation</h1>;

function App() {
  return (
    <Router>
      <div className="App container">
        <nav>
          <Link to="/">Home</Link>
          <Link to="/ranking">Ranking</Link>
          <Link to="/suggestion">Suggestion</Link>
          <Link to="/recommendation">Recommendation</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/ranking" element={<Ranking />} />
          <Route path="/suggestion" element={<Suggestion />} />
          <Route path="/recommendation" element={<Recommendation />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
