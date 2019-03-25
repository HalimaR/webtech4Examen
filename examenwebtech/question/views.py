from django.shortcuts import render
from django.http import HttpResponse
from django.utils import timezone

# Create your views here.


def question(request):
    now = timezone.localtime()
    return render(request,'question/timezone.html',{'now': now})
