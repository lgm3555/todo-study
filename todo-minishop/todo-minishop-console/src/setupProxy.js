/**
 * 테스트시에만 사용
 */
const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/auth',
    createProxyMiddleware({
      target: 'http://localhost:8080',
      changeOrigin: true
    })
  );
};