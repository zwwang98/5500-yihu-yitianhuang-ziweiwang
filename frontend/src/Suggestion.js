import axios from "axios";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import { CircularProgress } from "@mui/material";

const Suggestion = () => {
  const [longtitude, setlongtitude] = useState(-122.3280325497587);
  const [latitude, setLatitude] = useState(47.59786388589972);

  const [loading, setLoading] = useState(false);
  const [data, setData] = useState();

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    if (name === "longtitude") {
      setlongtitude(value);
    } else {
      setLatitude(value);
    }
  };

  const handleOnClick = () => {
    setLoading(true);
    // Handle form submission here
    console.log({ longtitude, latitude });
    axios
      .get(
        `http://localhost:8080/recommendation/activity/location/${latitude}/${longtitude}`
      )
      .then((data) => {
        console.log("data", data.data);
        setData(data.data);
        setLoading(false);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Handle form submission here
    console.log({ longtitude, latitude });
  };

  return (
    <div>
      <h1>Suggestion</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="longtitude">longtitude:</label>
        <input
          type="number"
          id="longtitude"
          name="longtitude"
          step="any"
          value={longtitude}
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
                <th scope="col">{`Suggested Activities on location {latitude: ${latitude}, longtitude: ${longtitude}}`}</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td scope="row">{Object.keys(data)[0].replaceAll("_", " ")}</td>
              </tr>
              <tr>
                <td scope="row">{Object.keys(data)[1].replaceAll("_", " ")}</td>
              </tr>
            </tbody>
          </table>
        </>
      )}
    </div>
  );
};

export default Suggestion;
