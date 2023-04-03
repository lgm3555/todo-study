import React from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import {Pagination, Stack} from "@mui/material";
import "./AngDictTable.scss";

const column = [
    { id: "standardWord", label: "키워드", minWidth: 80 },
    { id: "sameWord", label: "유사어", minWidth: 120 },
    { id: "type", label: "타입", minWidth: 50 },
    { id: "date", label: "변경일", minWidth: 80 },
];

function AngDictTable(props) {
    const [page, setPage] = React.useState(0);
    const rowsPerPage = 15;

    const handlePaging = (e) => {
        console.log(e);
    }

    return (
        <div>
            <div className="dict_table">
                <TableContainer className="table_container">
                    <div className="table_title">
                        <span>{props.type == "danawa" ? "다나와" : "에누리"}</span>
                        <span>{(props.data).length} 건</span>
                    </div>
                    <Table>
                        <TableHead>
                            <TableRow>
                                {column.map((column) => (
                                    <TableCell className="table_head_cell" key={column.id} style={{ minWidth: column.minWidth }}>
                                        {column.label}
                                    </TableCell>
                                ))}
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {
                                console.log(props.data)


                                /*props.data
                                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                                .map((row) => {
                                    return (
                                        <TableRow hover role="checkbox" tabIndex={-1} key={row.seq}>
                                            {column.map((column) => {
                                                return (
                                                    <TableCell className="table_body_cell" key={column.id}>
                                                        {row[column.id] }
                                                    </TableCell>
                                                );
                                            })}
                                        </TableRow>
                                    );
                                })*/
                            }
                        </TableBody>
                    </Table>
                </TableContainer>
                <Pagination className="dict_table_page" count={5} variant="outlined" shape="rounded" onClick={(e) => handlePaging(e)} />
            </div>
        </div>
    );
}

export default AngDictTable;