import axios from "axios";
import React, { useState, useEffect } from "react";
import { CircularProgress } from "@mui/material";

const RankActivityByCalories = () => {
  const [data, setData] = useState();
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    axios.get("http://localhost:8080/rank/activity/calories").then((res) => {
      setData(res.data);
      setLoading(false);
    });
  }, []);

  return (
    <>
      {loading && <CircularProgress />}
      {!loading && (
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Priority</th>
              <th scope="col">Activigy</th>
            </tr>
          </thead>
          <tbody>
            {data &&
              data.map((obj) => {
                const key = Object.keys(obj)[0];
                const value = obj[key];
                return (
                  <tr>
                    <td scope="row">{key.replaceAll("_", " ")}</td>
                    <td scope="row">{value}</td>
                  </tr>
                );
              })}
          </tbody>
        </table>
      )}
    </>
  );
};

export default RankActivityByCalories;
