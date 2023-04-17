import axios from "axios";
import React, { useState, useEffect } from "react";
import { CircularProgress } from "@mui/material";

const RankLocation = ({ base }) => {
  const [data, setData] = useState();
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    axios
      .get(`${base}/rank/location`)
      .then((res) => {
        setData(res.data);
        setLoading(false);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <>
      {loading && <CircularProgress />}
      {!loading && (
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Rank</th>
              <th scope="col">Location</th>
            </tr>
          </thead>
          <tbody>
            {data &&
              data.map((obj, index) => {
                return (
                  <tr>
                    <td scope="row">{index + 1}</td>
                    <td>{obj}</td>
                  </tr>
                );
              })}
          </tbody>
        </table>
      )}
    </>
  );
};

export default RankLocation;
