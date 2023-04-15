import axios from "axios";
import React, { useState, useEffect } from "react";
import { CircularProgress } from "@mui/material";

const RankActivityByFreq = ({ base }) => {
  const [data, setData] = useState();
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    axios.get(`${base}/rank/activity/freq`).then((res) => {
      setData(res.data);
      setLoading(false);
    });
  }, []);

  return (
    <>
      {" "}
      {loading && <CircularProgress />}
      {!loading && (
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Activigy</th>
              <th scope="col">Frequency</th>
            </tr>
          </thead>
          <tbody>
            {data &&
              data.map((obj) => {
                const key = Object.keys(obj)[0];
                const value = obj[key];
                return (
                  <tr>
                    <td scope="row">{key.replace(/_/g, " ")}</td>
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

export default RankActivityByFreq;
