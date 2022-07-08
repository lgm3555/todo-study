import time
import redis
from flask import Flask
from markupsafe import escape

py_app = Flask(__name__)
db_cache = redis.Redis(host='redis', port=6379)

def web_hit_cnt():
    return db_cache.incr('hits')

@py_app.route('/')
def python_flask():
    cnt = web_hit_cnt()

    return '<h1> test <h1>'

if __name__ == '__main__':
    py_app.run(host='0.0.0.0', port=9000, debug=True)
