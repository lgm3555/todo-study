from flask import Flask

py_app = Flask(__name__)

@py_app.route('/')
def python_flask():
    return "<h1>test</h1>"

if __name__ == '__main__':
    py_app.run(host='0.0.0.0', port=9000, debug=True)
