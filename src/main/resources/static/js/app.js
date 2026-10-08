function toggleSidebar(){document.getElementById('sidebar')?.classList.toggle('show')}
function confirmarEliminacion(){return confirm('¿Estás seguro de eliminar este registro? Esta acción no se puede deshacer.');}
document.addEventListener('DOMContentLoaded',()=>{document.querySelectorAll('.btn').forEach(b=>b.addEventListener('click',()=>{if(b.form && b.type==='submit') b.innerHTML='<span class="spinner-border spinner-border-sm me-1"></span> Guardando...';}));});
