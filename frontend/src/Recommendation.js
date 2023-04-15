import axios from "axios";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import { CircularProgress } from "@mui/material";
import styles from "./Recommendation.module.css";
import "bootstrap/dist/css/bootstrap.css";

const Recommendation = ({ base }) => {
  const [height, setHeight] = useState(175);
  const [weight, setWeight] = useState(100);
  const [gender, setGender] = useState("male");
  const [age, setAge] = useState(22);

  const [loading, setLoading] = useState(false);
  const [data, setData] = useState();

  const handleOnClick = () => {
    setLoading(true);
    // Handle form submission here
    axios
      .get(
        `${base}/recommendation/activity/height/${height}/weight/${weight}/gender/${gender}/age/${age}`
      )
      .then((data) => {
        console.log("data", data.data);
        setData(data.data);
        setLoading(false);
      });
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    switch (name) {
      case "height":
        setHeight(value);
        break;
      case "weight":
        setWeight(value);
        break;
      case "gender":
        setGender(value);
        break;
      case "age":
        setAge(value);
        break;
      default:
        break;
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Handle form submission here
    console.log({ height, weight, gender, age });
  };

  return (
    <div>
      <h1>Recommendation</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="height">Height (0 - 250):</label>
        <input
          type="number"
          id="height"
          name="height"
          min="0"
          max="250"
          value={height}
          onChange={handleInputChange}
        />
        <br />
        <label htmlFor="weight">Weight (0 - 1000):</label>
        <input
          type="number"
          id="weight"
          name="weight"
          min="0"
          max="1000"
          value={weight}
          onChange={handleInputChange}
        />
        <br />
        <label htmlFor="gender">Gender:</label>
        <select
          name="gender"
          id="gender"
          value={gender}
          onChange={handleInputChange}
        >
          <option value="">Select gender</option>
          <option value="male">Male</option>
          <option value="female">Female</option>
        </select>
        <br />
        <label htmlFor="age">Age (0 - 120):</label>
        <input
          type="number"
          id="age"
          name="age"
          min="0"
          max="120"
          value={age}
          onChange={handleInputChange}
        />
        <br />
        <Link type="submit" className="btn btn-primary" onClick={handleOnClick}>
          Submit
        </Link>
      </form>

      {loading && <CircularProgress />}
      {data && (
        <>
          <table className="table">
            <thead>
              <tr>
                <th scope="col">Suggested Activities</th>
                <th scope="col">Time(mins)</th>
              </tr>
            </thead>
            <tbody>
              {Object.keys(data).map((key) => {
                const value = data[key];
                console.log(key, value);
                return (
                  <tr>
                    <td scope="row">{key}</td>
                    <td>{value}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
};

export default Recommendation;
