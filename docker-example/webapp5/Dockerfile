FROM golang:alpine

COPY helloworld.go .

#RUN go install github.com/gin-gonic/gin


RUN go build helloworld.go

EXPOSE $PORT

CMD ["./helloworld.go"] 
