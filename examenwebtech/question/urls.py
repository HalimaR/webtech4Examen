from django.urls import path
from . import views

urlpatterns = [
    path('time/', views.question, name='question_time'),
]
