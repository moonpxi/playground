from app import api
from flask import Flask, render_template
app = Flask(__name__)


@app.route('/')
def homepage():
    return render_template('homepage.html', app_name=api.app_name())

@app.route('/create-account', methods=['GET', 'POST'])
def create_account():
    return render_template('create_account.html')