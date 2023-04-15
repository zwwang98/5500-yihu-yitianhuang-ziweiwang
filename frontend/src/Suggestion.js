import React, { useState } from "react";

const Suggestion = () => {
  const [longitude, setLongitude] = useState("");
  const [latitude, setLatitude] = useState("");

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    if (name === "longitude") {
      setLongitude(value);
    } else {
      setLatitude(value);
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Handle form submission here
    console.log({ longitude, latitude });
  };

  return (
    <div>
      <h1>Suggestion</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="longitude">Longitude:</label>
        <input
          type="number"
          id="longitude"
          name="longitude"
          step="any"
          value={longitude}
          onChange={handleInputChange}
        />
        <br />
        <label htmlFor="latitude">Latitude:</label>
        <input
          type="number"
          id="latitude"
          name="latitude"
          step="any"
          value={latitude}
          onChange={handleInputChange}
        />
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default Suggestion;
