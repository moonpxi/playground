from app.models import Session, Config


def app_name():
    return Session().query(Config).first().app_name