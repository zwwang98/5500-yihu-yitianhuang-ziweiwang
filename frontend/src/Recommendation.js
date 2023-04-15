import React, { useState } from "react";
import styles from "./Recommendation.module.css";
import "bootstrap/dist/css/bootstrap.css";

const Recommendation = () => {
  const [height, setHeight] = useState("");
  const [weight, setWeight] = useState("");
  const [gender, setGender] = useState("");
  const [age, setAge] = useState("");

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
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default Recommendation;
