import React from "react";
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import "./App.css";
import Suggestion from "./Suggestion.js";
import Recommendation from "./Recommendation.js";
import Ranking from "./pages/ranking/index.js";
import BasicTabs from "./pages/tabs";
import "bootstrap/dist/css/bootstrap.css";

const BASE_API = process.env.BASE_API || "http://54.212.1.186:8080";

const Home = () => <h1>Hello!</h1>;

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
          <Route path="/ranking" element={<Ranking base={BASE_API} />} />
          <Route path="/suggestion" element={<Suggestion base={BASE_API} />} />
          <Route
            path="/recommendation"
            element={<Recommendation base={BASE_API} />}
          />
          <Route path="/tabs" element={<BasicTabs />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
