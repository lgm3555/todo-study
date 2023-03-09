import React from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import {Pagination, Stack} from "@mui/material";
import danawa from '../../assets/image/danawa.png';
import enuri from '../../assets/image/enuri.png';
import "./DictTable.scss";

const columns = [
    { id: "word", label: "키워드", minWidth: 100 },
    { id: "status", label: "단어", minWidth: 50 },
    { id: "date", label: "변경일", minWidth: 80 },
];

const data = [
    { id: 1, word: "노트북", status: "등록", date: "2023-02-01 15:00:00" },
    { id: 2, word: "사과", status: "변경", date: "2023-03-15 10:10:50" },
    { id: 3, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 4, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 5, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 6, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 7, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 8, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 9, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 10, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 11, word: "노트북", status: "등록", date: "2023-02-01 15:00:00" },
    { id: 12, word: "사과", status: "변경", date: "2023-03-15 10:10:50" },
    { id: 13, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 14, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 15, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 16, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 17, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 18, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 19, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
    { id: 20, word: "가나다", status: "삭제", date: "2023-04-11 11:52:00" },
];

function DictTable(props) {
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(15);

    return (
        <div>
            <div className="dict_table">
                <TableContainer className="table_container">
                    <div className="table_title">
                        <img src={props.type == "danawa" ? danawa : enuri} />
                        <span>50건</span>
                    </div>
                    <Table>
                        <TableHead>
                            <TableRow>
                                {columns.map((column) => (
                                    <TableCell className="table_head_cell" key={column.id} style={{ minWidth: column.minWidth }}>
                                        {column.label}
                                    </TableCell>
                                ))}
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {data
                                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                                .map((row) => {
                                    return (
                                        <TableRow hover role="checkbox" tabIndex={-1} key={row.id}>
                                            {columns.map((column) => {
                                                return (
                                                    <TableCell className="table_body_cell" key={column.id}>
                                                        { row[column.id] }
                                                    </TableCell>
                                                );
                                            })}
                                        </TableRow>
                                    );
                                })}
                        </TableBody>
                    </Table>
                </TableContainer>
                <Pagination className="dict_table_page" count={5} variant="outlined" shape="rounded" />
            </div>

        </div>
    );
}

export default DictTable;