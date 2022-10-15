from flask import Flask, render_template, url_for, request
import requests
#from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
#database for the products that are up for a consortion
'''app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test.db'
db = SQLAlchemy(app)

class Products(db.Model):
    id = db.Column(db.integer, primary_key=True)
    title = db.column(db.string(200), nullable=False)
    content = db.column(db.string(200), nullable=False)
    price = db.column(db.double, nullable=False)

    def __repr__(self):
        return '<Task %r>' % self.id
'''

@app.route("/", methods=['GET', 'POST'])
def index():
    return render_template('landingpage.html')

@app.route("/form", methods=['GET', 'POST'])
def form():
    return render_template('Ravi_Nayak_Task1_40349442.html')

@app.route("/proceed", methods=['GET', 'POST'])
def proceed():
    # formContent =  {"contractType":"housing","name":"Bruno","gender":"male","address":"Hack1 The Hub Rd, 13","amountPpm":100.0}
    # formJson = request.form.to_dict(flat=False)

    javaBackEndURL = 'http://localhost:8080/hackthehub/contractIt'
    requests.post(javaBackEndURL, json = request.form)

    return render_template('proceed.html')


if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=80)