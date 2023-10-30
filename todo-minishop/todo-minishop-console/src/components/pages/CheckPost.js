import * as React from 'react';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import Card from '@mui/material/Card';
import CardActionArea from '@mui/material/CardActionArea';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import {CardActions} from "@mui/material";
import Button from "@mui/material/Button";

function CheckPost(props) {
    const { post } = props;

    const truncatedDescription = post.description.length > 40
        ? `${post.description.slice(0, 40)}...`
        : post.description;

    return (
        <Grid item xs={4} md={3}>
            <CardActionArea component="a" href="#" sx={{ display: 'flex', justifyContent: 'center' }}>
                <Card sx={{ maxWidth: '85%' }}>
                    <CardMedia
                        component="img"
                        alt="green iguana"
                        height="450"
                        image={post.imageUrl}
                    />
                    <CardContent>
                        <Typography gutterBottom variant="h7" component="div" style={{ height: "60px", overflow: "hidden" }}>
                            {post.productName}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            {truncatedDescription}
                        </Typography>
                    </CardContent>
                    <CardActions sx={{ justifyContent: "space-between" }}>
                        <Button size="small">장바구니 담기</Button>
                        <Button size="small">상세페이지</Button>
                    </CardActions>
                </Card>
            </CardActionArea>
        </Grid>
    );
}

export default CheckPost;