import * as React from 'react';
import {Alert} from "@mui/material";

export default function Toast(props) {
    React.useEffect(() => {
        const timer = setTimeout(() => {
            props.setToast(false);
        }, 2000)
    }, [props.setToast])
    return (
        <Alert
            sx={{
                marginTop: 5
            }}
            severity={props.status}
        >
            {props.message}
        </Alert>
    )
}