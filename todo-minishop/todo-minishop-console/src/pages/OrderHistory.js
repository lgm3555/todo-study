import React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {orderHistory, orderHistoryDetail} from "../services/ProductService";
import {Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle} from "@mui/material";

const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
        fontSize: 14,
    },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
        backgroundColor: theme.palette.action.hover,
    },
    // hide last border
    '&:last-child td, &:last-child th': {
        border: 0,
    },
}));

const OrderHistory = () => {

    const [info, setInfo] = React.useState({});
    const [detailInfo, setDetailInfo] = React.useState({});
    const [open, setOpen] = React.useState(false);

    React.useEffect(() => {
        orderHistory().then((res) => {
            if (res.data) {
                setInfo(res.data)
            }
        }).catch(err => {

        })
    }, [])

    const handleOpen = (orderSeq) => {
        orderHistoryDetail(orderSeq).then((res) => {
            console.log(res.data)
            if (res.data) {
                setDetailInfo(res.data)
            }
        })
        setOpen(true);
    }

    const handleClose = () => {
        setOpen(false);
    }

    return (
        <TableContainer component={Paper}>
            <Table aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <StyledTableCell>주문 번호</StyledTableCell>
                        <StyledTableCell>상품명</StyledTableCell>
                        <StyledTableCell>배송상태</StyledTableCell>
                        <StyledTableCell>금액</StyledTableCell>
                        <StyledTableCell>주문날짜</StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {info.length && info.map((row) => (
                        <StyledTableRow  key={row.orderSeq}>
                            <StyledTableCell onClick={() => handleOpen(row.orderSeq)} component="th" scope="row">
                                {row.orderSeq}
                            </StyledTableCell>
                            <StyledTableCell>{row.product[0].productName} 외 {row.product.length}건</StyledTableCell>
                            <StyledTableCell>{row.statement}</StyledTableCell>
                            <StyledTableCell>{row.paymentAmount}</StyledTableCell>
                            <StyledTableCell>{row.orderDate}</StyledTableCell>
                        </StyledTableRow >
                    ))}
                </TableBody>
            </Table>
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                    주문번호 : {detailInfo.orderSeq}
                </DialogTitle>
                <DialogContent>
                    <Table aria-label="simple table">
                        <TableBody>
                            <StyledTableRow>
                                <StyledTableCell>받는사람</StyledTableCell>
                                <StyledTableCell>{detailInfo.reciver}</StyledTableCell>
                            </StyledTableRow>
                            <StyledTableRow>
                                <StyledTableCell>전화번호</StyledTableCell>
                                <StyledTableCell>{detailInfo.phone}</StyledTableCell>
                            </StyledTableRow>
                            <StyledTableRow>
                                <StyledTableCell>이메일</StyledTableCell>
                                <StyledTableCell>{detailInfo.email}</StyledTableCell>
                            </StyledTableRow>
                            <StyledTableRow>
                                <StyledTableCell>주소</StyledTableCell>
                                <StyledTableCell>{detailInfo.address}</StyledTableCell>
                            </StyledTableRow>
                            <StyledTableRow>
                                <StyledTableCell></StyledTableCell>
                                <StyledTableCell></StyledTableCell>
                            </StyledTableRow>
                            <StyledTableRow>
                                <StyledTableCell>상품번호</StyledTableCell>
                                <StyledTableCell>상품명</StyledTableCell>
                                <StyledTableCell>가격</StyledTableCell>
                            </StyledTableRow>
                            {(detailInfo.product) && detailInfo.product.map((row) => (
                                <StyledTableRow  key={row.productCode}>
                                    <StyledTableCell component="th" scope="row">{row.productCode}</StyledTableCell>
                                    <StyledTableCell>{row.productName}</StyledTableCell>
                                    <StyledTableCell>{row.price}</StyledTableCell>
                                </StyledTableRow>
                            ))}
                        </TableBody>
                    </Table>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>닫기</Button>
                </DialogActions>
            </Dialog>
        </TableContainer>
    );
}

export default OrderHistory;