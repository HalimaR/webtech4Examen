from django.shortcuts import render
from django.http import HttpResponse
from django.utils import timezone

# Create your views here.


def question(request):
    now = timezone.localtime(timezone.get_current_timezone)
    return render(request,'question/timezone.html',{'now': now})
