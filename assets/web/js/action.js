function getListEditions()
{
	window.MyCls.getListofEditions();
}

function mDown(obj)
{
	obj.style.backgroundColor="#1ec5e5";	
	document.getElementById('foo').className = 'shadowimg';
}

function mUp(obj)
{
	obj.style.backgroundColor="#ffffff";
	document.getElementById('foo').className = 'shadowimgnrml';	
}